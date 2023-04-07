package com.example.testtaskqulisoft.presentation.ui.photos

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView

import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.map
import com.example.testtaskqulisoft.R
import com.example.testtaskqulisoft.databinding.FragmentPhotosBinding
import com.example.testtaskqulisoft.domain.PhotoDomain
import com.example.testtaskqulisoft.presentation.BaseFragment
import com.example.testtaskqulisoft.presentation.adapters.PhotoClick
import com.example.testtaskqulisoft.presentation.adapters.PhotosAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PhotosFragment : BaseFragment<FragmentPhotosBinding>(FragmentPhotosBinding::inflate), PhotoClick {

    private val viewModel : PhotosViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost = requireActivity()

        val adapter = PhotosAdapter(
            this
        )
        viewModel.fetchPhotos("cats")
        viewModel.photosData.observe(viewLifecycleOwner) { photos ->
            if (photos != null){
                binding.progressPhotos.isVisible = false
                adapter.submitData(viewLifecycleOwner.lifecycle, photos)
            } else {
                binding.progressPhotos.isVisible = true
            }
        }

        binding.apply {
            listPhotos.setHasFixedSize(true)
            listPhotos.adapter = adapter
        }


        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_photos, menu)

                val searchItem = menu.findItem(R.id.action_seacrh)
                val searchView = searchItem.actionView as SearchView

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        if (query != null){
                            binding.listPhotos.scrollToPosition(0)
                            viewModel.fetchPhotos(query)
                            searchView.clearFocus()
                        }
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        return true
                    }

                })

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }



    override fun click(photo: PhotoDomain) {
        findNavController().navigate(PhotosFragmentDirections.actionPhotosFragmentToDetailsFragment(photo))
    }

}