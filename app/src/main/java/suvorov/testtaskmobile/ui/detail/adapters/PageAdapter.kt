package suvorov.testtaskmobile.ui.detail.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import suvorov.testtaskmobile.ui.feature.FeatureFragment
import suvorov.testtaskmobile.ui.info.InfoFragment
import suvorov.testtaskmobile.ui.shop.ShopFragment

class PageAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    data class Page(val fragment: () -> Fragment)

    private val pages = listOf(
        Page { ShopFragment() },
        Page { InfoFragment() },
        Page { FeatureFragment() }
    )

    override fun getItemCount(): Int {
        return pages.size
    }

    override fun createFragment(position: Int): Fragment {
        return pages[position].fragment()
    }
}