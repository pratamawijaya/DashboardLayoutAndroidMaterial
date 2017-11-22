package pratamawijaya.com.dashboardlayout.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.github.nitrico.lastadapter.LastAdapter
import com.github.nitrico.lastadapter.Type
import kotlinx.android.synthetic.main.layout_content.appBarLayout
import kotlinx.android.synthetic.main.layout_content.collapsingToolbar
import kotlinx.android.synthetic.main.layout_content.containerBanner
import kotlinx.android.synthetic.main.layout_content.indicator
import kotlinx.android.synthetic.main.layout_content.rvContent
import kotlinx.android.synthetic.main.layout_content.toolbar
import kotlinx.android.synthetic.main.layout_content.viewPager
import pratamawijaya.com.dashboardlayout.BR
import pratamawijaya.com.dashboardlayout.R
import pratamawijaya.com.dashboardlayout.databinding.ItemCoinBinding
import pratamawijaya.com.dashboardlayout.model.Coin
import pratamawijaya.com.dashboardlayout.ui.adapter.BannerFragmentAdapter

class MainActivity : AppCompatActivity() {


    private lateinit var pagerAdapter: BannerFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupAppBarLayout()
        setupViewPager()
        setupRecyclerView()
        setupContent()
    }

    private fun setupViewPager() {

        // add more banner here
        val listBanner = listOf(
                "http://animals.sandiegozoo.org/sites/default/files/2016-08/hero_zebra_animals.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/Equus_quagga.jpg/1200px-Equus_quagga.jpg",
                "http://4.bp.blogspot.com/-3u3BGiW8508/VmZV8-yxRCI/AAAAAAAABEc/joWSaqvPGak/s1600/Fakta%2BUnik%2BJerapah%2Byang%2BHarus%2BKamu%2BKetahui1.jpg"
        )
        pagerAdapter = BannerFragmentAdapter(supportFragmentManager, listBanner)
        viewPager.adapter = pagerAdapter
        indicator.setViewPager(viewPager)
    }

    private fun setupAppBarLayout() {
        appBarLayout.addOnOffsetChangedListener { _, verticalOffset ->
            if (verticalOffset <= -containerBanner.height / 2) collapsingToolbar.title = "Dashboard" else collapsingToolbar.title = ""
        }
    }

    private fun setupContent() {
        val listOfCoin = listOf(
                Coin("Bitcoin", R.drawable.ic_bitcoin),
                Coin("Etherium", R.drawable.ic_etherium),
                Coin("Litecoin", R.drawable.ic_litecoin),
                Coin("Bitcoin", R.drawable.ic_bitcoin),
                Coin("Etherium", R.drawable.ic_etherium),
                Coin("Litecoin", R.drawable.ic_litecoin),
                Coin("Bitcoin", R.drawable.ic_bitcoin),
                Coin("Etherium", R.drawable.ic_etherium),
                Coin("Litecoin", R.drawable.ic_litecoin),
                Coin("Bitcoin", R.drawable.ic_bitcoin),
                Coin("Etherium", R.drawable.ic_etherium),
                Coin("Litecoin", R.drawable.ic_litecoin),
                Coin("Bitcoin", R.drawable.ic_bitcoin),
                Coin("Etherium", R.drawable.ic_etherium),
                Coin("Litecoin", R.drawable.ic_litecoin),
                Coin("Bitcoin", R.drawable.ic_bitcoin),
                Coin("Etherium", R.drawable.ic_etherium),
                Coin("Litecoin", R.drawable.ic_litecoin)
        )
        LastAdapter(listOfCoin, BR.item)
                .map<Coin>(Type<ItemCoinBinding>(R.layout.item_coin).onClick {
                    Toast.makeText(this@MainActivity, "${it.binding.item?.name} pos ${it.adapterPosition}", Toast.LENGTH_SHORT).show()
                })
                .into(rvContent)
    }

    private fun setupRecyclerView() {
        rvContent.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }
}