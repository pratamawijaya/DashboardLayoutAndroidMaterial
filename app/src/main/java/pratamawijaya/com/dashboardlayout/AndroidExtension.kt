package pratamawijaya.com.dashboardlayout

import android.databinding.BindingAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by pratama on 11/22/17.
 */

@BindingAdapter("load_image")
fun ImageView.loadImage(imageId: Int) {
    this.setImageResource(imageId)
}

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}