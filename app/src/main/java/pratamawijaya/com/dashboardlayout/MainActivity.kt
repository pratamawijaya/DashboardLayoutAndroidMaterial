package pratamawijaya.com.dashboardlayout

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_content.appBarLayout
import kotlinx.android.synthetic.main.layout_content.collapsingToolbar
import kotlinx.android.synthetic.main.layout_content.imgContent
import kotlinx.android.synthetic.main.layout_content.toolbar
import pratamawijaya.com.dashboardlayout.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupAppBarLayout()
        setupNavigationView()
        setupContent(HomeFragment())
    }

    private fun setupNavigationView() {
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener { it ->
            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(this@MainActivity, "Nav home", Toast.LENGTH_SHORT).show()
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

    private fun setupContent(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }

}