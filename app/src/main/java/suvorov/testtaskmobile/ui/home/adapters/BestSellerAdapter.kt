package suvorov.testtaskmobile.ui.home.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import suvorov.testtaskmobile.R
import suvorov.testtaskmobile.domain.model.BestSeller
import suvorov.testtaskmobile.databinding.ItemBestSellerBinding
import suvorov.testtaskmobile.ui.home.adapters.clicklistener.PhoneClickListener
import suvorov.testtaskmobile.ui.home.adapters.viewholders.BestSellerViewHolder

class BestSellerAdapter(
    private val phoneClickListener: PhoneClickListener
): RecyclerView.Adapter<BestSellerViewHolder>() {

    private val bestSellerList = arrayListOf<BestSeller>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        return BestSellerViewHolder(
            ItemBestSellerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        holder.bind(bestSellerList[position], phoneClickListener)
    }

    override fun getItemCount(): Int {
        return bestSellerList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(context: Context, list: List<BestSeller>, brand: String, priceRange: IntRange) {
        bestSellerList.clear()
        if(priceRange.last != 0) {
            for(bestSeller in list) {
                if(bestSeller.title.contains(brand) &&
                    priceRange.contains(bestSeller.priceWithoutDiscount)) {
                    bestSellerList.add(bestSeller)
                }
                if(bestSeller.title.contains(brand) &&
                    priceRange == 0..10000) {
                    bestSellerList.add(bestSeller)
                }
                if(brand == context.getString(R.string.all_brands) &&
                    priceRange.contains(bestSeller.priceWithoutDiscount)) {
                    bestSellerList.add(bestSeller)
                }
            }
        }
        else bestSellerList.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearList() {
        bestSellerList.clear()
        notifyDataSetChanged()
    }
}