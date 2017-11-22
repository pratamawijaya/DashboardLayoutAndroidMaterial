package pratamawijaya.com.dashboardlayout.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import pratamawijaya.com.dashboardlayout.ui.BannerFragment

/**
 * Created by pratama on 11/22/17.
 */
class BannerFragmentAdapter constructor(fragmentManager: FragmentManager, val urls: List<String>)
    : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = BannerFragment.newInstance(urls[position])

    override fun getCount(): Int = urls.size
}