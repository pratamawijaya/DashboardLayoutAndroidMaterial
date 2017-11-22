package pratamawijaya.com.dashboardlayout.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_banner.imgBanner
import pratamawijaya.com.dashboardlayout.R
import pratamawijaya.com.dashboardlayout.loadImageFromURL


/**
 * A simple [Fragment] subclass.
 */
class BannerFragment : Fragment() {

    companion object {
        /**
         * new instance pattern for fragment
         */
        @JvmStatic
        fun newInstance(url: String): BannerFragment {
            val newsFragment = BannerFragment()
            val args = Bundle()
            args.putString("data", url)
            newsFragment.arguments = args

            return newsFragment
        }
    }

    private var url: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        url = arguments.getString("data")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_banner, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("tag", "url -> $url")
        imgBanner.loadImageFromURL(url)
    }

}
