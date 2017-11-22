package pratamawijaya.com.dashboardlayout

import android.databinding.BindingAdapter
import android.widget.ImageView

/**
 * Created by pratama on 11/22/17.
 */

@BindingAdapter("load_image")
fun ImageView.loadImage(imageId: Int) {
    this.setImageResource(imageId)
}
