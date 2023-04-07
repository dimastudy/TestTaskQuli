package com.example.testtaskqulisoft.presentation.ui.details

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.testtaskqulisoft.R
import com.example.testtaskqulisoft.databinding.FragmentDetailsBinding
import com.example.testtaskqulisoft.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val viewModel: DetailsViewModel by viewModels {
        val photo = DetailsFragmentArgs.fromBundle(requireArguments()).photo
        DetailsViewModel.DetailsFactory(photo)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.observePhoto(viewLifecycleOwner) {photo ->
            if (photo != null) {
                Glide.with(requireContext())
                    .load(photo)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .placeholder(R.drawable.no_image)
                    .into(binding.imageFull)
            }
        }

    }

}