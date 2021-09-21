package com.smendon.android.dynamicdashboard

import android.app.Application
import com.smendon.android.dynamicdashboard.datasource.AppRepository
import com.smendon.android.dynamicdashboard.factory.DashboardVMFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class DmartApp : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@DmartApp))

        bind() from singleton { AppRepository(instance()) }
        bind() from provider { DashboardVMFactory(instance()) }
    }
}