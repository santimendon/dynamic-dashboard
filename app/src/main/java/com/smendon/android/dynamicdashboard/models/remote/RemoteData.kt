package com.smendon.android.dynamicdashboard.models.remote

import com.smendon.android.dynamicdashboard.models.ui.ItemData

class RemoteData : ArrayList<RemoteItem>()

data class RemoteItem(
    val `data`: List<ItemData>,
    val title: String,
    val type: String,
    val span: Int = 0
)