package pratamawijaya.com.dashboardlayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.github.nitrico.lastadapter.LastAdapter
import com.github.nitrico.lastadapter.Type
import kotlinx.android.synthetic.main.layout_content.appBarLayout
import kotlinx.android.synthetic.main.layout_content.collapsingToolbar
import kotlinx.android.synthetic.main.layout_content.imgContent
import kotlinx.android.synthetic.main.layout_content.rvContent
import kotlinx.android.synthetic.main.layout_content.toolbar
import pratamawijaya.com.dashboardlayout.databinding.ItemCoinBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupAppBarLayout()
        setupRecyclerView()

        setupContent()
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
                .map<Coin>(Type<ItemCoinBinding>(R.layout.item_coin))
                .into(rvContent)
    }

    private fun setupRecyclerView() {
        rvContent.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }
}