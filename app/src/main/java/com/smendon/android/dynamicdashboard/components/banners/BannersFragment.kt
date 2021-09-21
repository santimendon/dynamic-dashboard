package com.smendon.android.dynamicdashboard.components.banners

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smendon.android.dynamicdashboard.R
import com.smendon.android.dynamicdashboard.binding.setImageURL
import com.smendon.android.dynamicdashboard.databinding.FragmentBannersBinding

class BannersFragment : Fragment() {

    private lateinit var binding: FragmentBannersBinding
    private val layoutId = R.layout.fragment_banners
    private lateinit var bannersVM: BannersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            onCreateViewBinding(inflater, container).apply { lifecycleOwner = viewLifecycleOwner }
        bannersVM =
            ViewModelProvider(this).get(BannersViewModel::class.java)
        return binding.root
    }

    private fun onCreateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBannersBinding {
        return DataBindingUtil.inflate(inflater, layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bannersVM.text.observe(viewLifecycleOwner, Observer {
            binding.textTitle.text = it
        })

        val url =
            "https://c8.alamy.com/comp/W194YN/sample-ribbon-sample-isolated-sign-sample-banner-W194YN.jpg"
        binding.imageBanner.setImageURL(url)
    }
}