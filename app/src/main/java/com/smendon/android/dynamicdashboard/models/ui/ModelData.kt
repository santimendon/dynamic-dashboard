package com.smendon.android.dynamicdashboard.models.ui

data class TitleData(val title: String) : BaseCell()

data class SectionTitleData(val title: String) : BaseCell()

data class BannerData(
    val id: Int? = 0,
    val title: String? = null,
    val imageURL: String? = null
) : BaseCell()

data class ItemData(
    val id: Int? = 0,
    val title: String? = null,
    val description: String? = null,
    val imageURL: String? = null,
    val price: String? = null,
    val weight: String? = null
) : BaseCell()

data class GridItemData(
    val span: Int = 0,
    val listOfItems: List<ItemData>
) : BaseCell()