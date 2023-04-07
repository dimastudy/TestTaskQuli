package com.example.testtaskqulisoft.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

open class BaseFragment<VB: ViewBinding>(private val inflaterLayout: (inflater: LayoutInflater) -> VB) : Fragment() {

    private var _binging: VB? = null
    protected val binding get() = _binging!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binging = inflaterLayout.invoke(inflater)
        return binding.root
    }

    override fun onDestroy() {
        _binging = null
        super.onDestroy()
    }


}