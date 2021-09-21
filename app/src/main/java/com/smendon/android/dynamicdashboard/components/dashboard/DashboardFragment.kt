package com.smendon.android.dynamicdashboard.components.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.smendon.android.dynamicdashboard.R
import com.smendon.android.dynamicdashboard.databinding.FragmentDashboardBinding
import com.smendon.android.dynamicdashboard.factory.DashboardVMFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class DashboardFragment : Fragment(), KodeinAware {
    override val kodein by kodein()

    private lateinit var binding: FragmentDashboardBinding
    private val factory: DashboardVMFactory by instance()
    private lateinit var dashboardVM: DashboardViewModel
    private val layoutId = R.layout.fragment_dashboard

    val dashboardController by lazy {
        DashboardController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            onCreateViewBinding(inflater, container).apply { lifecycleOwner = viewLifecycleOwner }
        dashboardVM =
            ViewModelProvider(this, factory).get(DashboardViewModel::class.java)
        return binding.root
    }

    private fun onCreateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return DataBindingUtil.inflate(inflater, layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.epoxyRecyclerView.setController(dashboardController)
        observeUI()
    }

    private fun observeUI() {
        dashboardVM.dashboardData.observe(viewLifecycleOwner, Observer {
            it?.apply {
                dashboardController.setData(this)
            }
        })

    }
}