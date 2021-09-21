package com.smendon.android.dynamicdashboard.components.dashboard

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelView
import com.smendon.android.dynamicdashboard.models.epoxy.GridItemModel

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class GridCarousal(context: Context) : Carousel(context) {
    override fun createLayoutManager(): LayoutManager {
        val spanCount = GridItemModel.getSpanSize()
        return GridLayoutManager(context, spanCount, GridLayoutManager.VERTICAL, false)
    }
}