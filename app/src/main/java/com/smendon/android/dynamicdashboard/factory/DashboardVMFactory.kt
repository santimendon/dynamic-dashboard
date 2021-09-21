package com.smendon.android.dynamicdashboard.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smendon.android.dynamicdashboard.components.dashboard.DashboardViewModel
import com.smendon.android.dynamicdashboard.datasource.AppRepository

@Suppress("UNCHECKED_CAST")
class DashboardVMFactory(
    private val repository: AppRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DashboardViewModel(repository) as T
    }
}