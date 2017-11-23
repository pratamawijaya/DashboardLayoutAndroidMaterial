package pratamawijaya.com.dashboardlayout

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_content.appBarLayout
import kotlinx.android.synthetic.main.layout_content.collapsingToolbar
import kotlinx.android.synthetic.main.layout_content.imgContent
import kotlinx.android.synthetic.main.layout_content.toolbar
import pratamawijaya.com.dashboardlayout.fragment.HomeFragment
import pratamawijaya.com.dashboardlayout.fragment.ViewPagerFragment

class MainActivity : AppCompatActivity(), MainActivityImpl {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupAppBarLayout()
        setupNavigationView()
        setFragment(HomeFragment())
    }

    private fun setupNavigationView() {
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener { it ->
            when (it.itemId) {
                R.id.nav_pager -> setFragment(ViewPagerFragment())
                R.id.nav_home -> setFragment(HomeFragment())
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }

    private fun setupAppBarLayout() {
        appBarLayout.addOnOffsetChangedListener { _, verticalOffset ->
            if (verticalOffset <= -imgContent.height / 2) {
                collapsingToolbar.title = "Dashboard"
            } else {
                collapsingToolbar.title = ""
            }

        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }

    override fun setBannerImage(imgRes: Int) {
        imgContent.loadImage(imgRes)
    }

}