package com.smendon.android.dynamicdashboard.components.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smendon.android.dynamicdashboard.datasource.AppRepository
import com.smendon.android.dynamicdashboard.models.ui.BaseCell

class DashboardViewModel(private val repository: AppRepository) : ViewModel() {

    val dashboardData by lazy { MutableLiveData<List<BaseCell>>() }

    init {
        setUI()
    }

    fun setUI() {
        dashboardData.postValue(repository.provideData())
    }
}