package pratamawijaya.com.dashboardlayout.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.github.nitrico.lastadapter.LastAdapter
import com.github.nitrico.lastadapter.Type
import kotlinx.android.synthetic.main.fragment_home.*
import pratamawijaya.com.dashboardlayout.*
import pratamawijaya.com.dashboardlayout.databinding.ItemCoinBinding

/**
 * Created by ocittwo on 11/22/17.
 */
class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_home)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LastAdapter(sampleDataCoin(), BR.item)
                .map<Coin>(Type<ItemCoinBinding>(R.layout.item_coin).onClick {
                    Toast.makeText(context, "${it.binding.item?.name} pos ${it.adapterPosition}", Toast.LENGTH_SHORT).show()
                })
                .into(rvContent)
        rvContent.apply {
            layoutManager = GridLayoutManager(context, 2)
        }

        getMainImpl().setBannerImage(R.drawable.jerapah)
    }

    fun getMainImpl(): MainActivityImpl{
        return activity as MainActivityImpl
    }
}
