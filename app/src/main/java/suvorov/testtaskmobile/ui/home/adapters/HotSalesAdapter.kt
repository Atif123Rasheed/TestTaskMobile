package suvorov.testtaskmobile.ui.home.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import suvorov.testtaskmobile.R
import suvorov.testtaskmobile.domain.model.HomeStore
import suvorov.testtaskmobile.databinding.ItemHotSalesBinding
import suvorov.testtaskmobile.ui.home.adapters.clicklistener.PhoneClickListener
import suvorov.testtaskmobile.ui.home.adapters.viewholders.HotSalesViewHolder

class HotSalesAdapter(
    private val phoneClickListener: PhoneClickListener
): RecyclerView.Adapter<HotSalesViewHolder>() {

    private val homeStoreList = arrayListOf<HomeStore>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesViewHolder {
        return HotSalesViewHolder(
            ItemHotSalesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HotSalesViewHolder, position: Int) {
        holder.bind(homeStoreList[position], phoneClickListener)
    }

    override fun getItemCount(): Int {
        return homeStoreList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(context: Context, list: List<HomeStore>, brand: String) {
        homeStoreList.clear()
        if(brand != context.getString(R.string.all_brands)) {
            for(homeStore in list) {
                if(homeStore.title.contains(brand)) {
                    homeStoreList.add(homeStore)
                }
            }
        }
        else homeStoreList.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearList() {
        homeStoreList.clear()
        notifyDataSetChanged()
    }
}