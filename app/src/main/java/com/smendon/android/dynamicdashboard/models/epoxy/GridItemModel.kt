package com.smendon.android.dynamicdashboard.models.epoxy

import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.smendon.android.dynamicdashboard.R
import com.smendon.android.dynamicdashboard.base.BaseEpoxyHolder
import com.smendon.android.dynamicdashboard.binding.setImageURL
import com.smendon.android.dynamicdashboard.models.ui.ItemData

@EpoxyModelClass(layout = R.layout.model_grid_item)
abstract class GridItemModel() : EpoxyModelWithHolder<GridItemVH>() {

    @EpoxyAttribute
    lateinit var title: String

    @EpoxyAttribute
    lateinit var imageUrl: String

    override fun bind(holder: GridItemVH) {
        holder.title.text = title
        holder.image.setImageURL(imageUrl)
    }

    override fun unbind(holder: GridItemVH) {
    }

    companion object {
        var GRID_SPAN: Int = 0

        fun mapGridItems(
            gridSpan: Int,
            data: List<ItemData>
        ): MutableList<GridItemModel_> {
            GRID_SPAN = gridSpan
            return mutableListOf<GridItemModel_>().apply {
                data.mapIndexed { i: Int, item: ItemData ->
                    add(
                        GridItemModel_()
                            .id("grid_item", i.toLong())
                            .title(item.title)
                            .imageUrl(item.imageURL)
                    )
                }
            }
        }

        fun getSpanSize() = if (GRID_SPAN == 0) 3 else GRID_SPAN
    }
}

class GridItemVH : BaseEpoxyHolder() {
    val title by bind<TextView>(R.id.tvGridTitle)
    val image by bind<AppCompatImageView>(R.id.ivImage)
}