package pratamawijaya.com.dashboardlayout.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.github.nitrico.lastadapter.LastAdapter
import com.github.nitrico.lastadapter.Type
import kotlinx.android.synthetic.main.fragment_pager_item.*
import pratamawijaya.com.dashboardlayout.*
import pratamawijaya.com.dashboardlayout.databinding.ItemItemBinding

/**
 * Created by ocittwo on 11/22/17.
 */

class PagerItemFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_pager_item)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LastAdapter(sampleDataItem(), BR.item)
                .map<Item>(Type<ItemItemBinding>(R.layout.item_item).onClick {
                    Toast.makeText(context, "${it.binding.item?.title} position ${it.adapterPosition}", Toast.LENGTH_SHORT).show()
                }).into(list_item)
        list_item.apply {
            layoutManager = LinearLayoutManager(context)
        }
    }
}
