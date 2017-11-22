package pratamawijaya.com.dashboardlayout

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by pratama on 11/22/17.
 */

@BindingAdapter("load_image")
fun ImageView.loadImage(imageId: Int) {
    this.setImageResource(imageId)
}

fun ImageView.loadImageFromURL(url: String) {
    Picasso.with(this.context).load(url).into(this)
}
