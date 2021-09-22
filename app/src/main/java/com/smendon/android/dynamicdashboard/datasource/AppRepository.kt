package com.smendon.android.dynamicdashboard.datasource

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.smendon.android.dynamicdashboard.R
import com.smendon.android.dynamicdashboard.models.remote.RemoteData
import com.smendon.android.dynamicdashboard.models.ui.*
import java.io.IOException

const val TYPE_BANNER = "banners"
const val TYPE_LIST = "list"
const val TYPE_GRID = "grid"

class AppRepository(
    context: Context
) {
    private val appContext = context.applicationContext

    fun provideData(): List<BaseCell> {
        val dataList = mutableListOf<BaseCell>()
        val remoteData = getMockData()
        dataList.add(TitleData(appContext.getString(R.string.label_welcome)))

        remoteData?.forEach { item ->
            when (item.type) {
                TYPE_BANNER -> {
                    dataList.add(SectionTitleData(item.title))
                    item.data.forEach {
                        dataList.add(
                            BannerData(
                                it.id, it.title, it.imageURL
                            )
                        )
                    }
                }
                TYPE_LIST -> {
                    dataList.add(SectionTitleData(item.title))
                    item.data.forEach {
                        dataList.add(it)
                    }
                }
                TYPE_GRID -> {
                    dataList.add(SectionTitleData(item.title))
                    dataList.add(GridItemData(span = item.span, item.data))
                }
            }
        }
        return dataList
    }

    private fun getMockData(): RemoteData? {
        try {
            val remoteJson = appContext.assets.open("remotedata.json")
                .bufferedReader().use { it.readText() }
            val gson = Gson()
            val remoteObjType = object : TypeToken<RemoteData>() {}.type
            return gson.fromJson(remoteJson, remoteObjType)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
        return null
    }
}