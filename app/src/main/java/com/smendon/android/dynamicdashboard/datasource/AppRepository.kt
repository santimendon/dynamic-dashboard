package com.smendon.android.dynamicdashboard.datasource

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.smendon.android.dynamicdashboard.models.remote.RemoteData
import com.smendon.android.dynamicdashboard.models.ui.BannerData
import com.smendon.android.dynamicdashboard.models.ui.BaseCell
import com.smendon.android.dynamicdashboard.models.ui.GridItemData
import com.smendon.android.dynamicdashboard.models.ui.SectionTitleData
import java.io.IOException

class AppRepository(
    context: Context
) {
    private val appContext = context.applicationContext

    fun provideData(): List<BaseCell> {
        val dataList = mutableListOf<BaseCell>()
        try {
            val remoteData = appContext.assets.open("remotedata.json")
                .bufferedReader().use { it.readText() }
            val gson = Gson()
            val remoteObjType = object : TypeToken<RemoteData>() {}.type
            val data: RemoteData = gson.fromJson(remoteData, remoteObjType)

            data.forEach { item ->
                if (item.type == "banners") {
                    Log.d("TAG", "Banners: " + item.data.size)
                    dataList.add(SectionTitleData(item.title))
                    item.data.forEach {
                        dataList.add(
                            BannerData(
                                it.id, it.title, it.imageURL
                            )
                        )
                    }
                } else if (item.type == "list") {
                    dataList.add(SectionTitleData(item.title))
                    item.data.forEach {
                        dataList.add(it)
                    }
                } else if (item.type == "grid") {
                    dataList.add(SectionTitleData(item.title))
                    dataList.add(GridItemData(span = item.span, item.data))
                }
            }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
        return dataList
    }
}