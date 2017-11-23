package pratamawijaya.com.dashboardlayout.fragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by ocittwo on 11/22/17.
 */

class PagerItemAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val title = listOf("Tab One", "Tab Two", "Tab Three", "Tab Four", "Tab Five","Tab Six")

    override fun getItem(position: Int): Fragment? {
        return PagerItemFragment()
    }

    override fun getCount(): Int {
        return title.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return title[position]
    }
}
