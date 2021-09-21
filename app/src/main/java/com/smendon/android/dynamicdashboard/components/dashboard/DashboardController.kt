package com.smendon.android.dynamicdashboard.components.dashboard

import com.airbnb.epoxy.TypedEpoxyController
import com.smendon.android.dynamicdashboard.bannerItem
import com.smendon.android.dynamicdashboard.listItem
import com.smendon.android.dynamicdashboard.models.epoxy.GridItemModel
import com.smendon.android.dynamicdashboard.models.ui.*
import com.smendon.android.dynamicdashboard.sectionTitle
import com.smendon.android.dynamicdashboard.title

class DashboardController : TypedEpoxyController<List<BaseCell>>() {
    override fun buildModels(data: List<BaseCell>?) {
        data?.forEachIndexed { index, cellData ->
            when (cellData) {
                is TitleData -> addTitle(cellData)
                is SectionTitleData -> addSectionTitle(cellData)
                is BannerData -> addBannerItem(cellData)
                is ItemData -> addListItem(cellData)
                is GridItemData -> addGridItem(index = index, cellData = cellData)
            }
        }
    }

    private fun addTitle(cellData: TitleData) {
        title {
            id("title")
            data(cellData)
        }
    }

    private fun addSectionTitle(cellData: SectionTitleData) {
        sectionTitle {
            id("sectionTitle/${cellData.title}")
            data(cellData)
        }
    }

    private fun addBannerItem(cellData: BannerData) {
        bannerItem {
            id(cellData.id)
            data(cellData)
        }
    }

    private fun addListItem(cellData: ItemData) {
        listItem {
            id(cellData.id)
            data(cellData)
        }
    }

    private fun addGridItem(index: Int, cellData: GridItemData) {
        gridCarousal {
            id("grid_items_$index")
            models(
                GridItemModel
                    .mapGridItems(gridSpan = cellData.span, cellData.listOfItems)

            )
        }
    }
}