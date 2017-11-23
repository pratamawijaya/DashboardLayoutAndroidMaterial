package pratamawijaya.com.dashboardlayout.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_view_pager.*
import pratamawijaya.com.dashboardlayout.MainActivityImpl
import pratamawijaya.com.dashboardlayout.R
import pratamawijaya.com.dashboardlayout.inflate

/**
 * Created by ocittwo on 11/22/17.
 */

class ViewPagerFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_view_pager)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PagerItemAdapter(childFragmentManager)
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)

        getMainImpl().setBannerImage(R.drawable.okapi)
    }

    fun getMainImpl(): MainActivityImpl {
        return activity as MainActivityImpl
    }
}
