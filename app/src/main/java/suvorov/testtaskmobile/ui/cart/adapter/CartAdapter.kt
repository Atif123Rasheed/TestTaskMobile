package suvorov.testtaskmobile.ui.cart.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import suvorov.testtaskmobile.domain.model.Basket
import suvorov.testtaskmobile.databinding.ItemCartBinding

class CartAdapter: RecyclerView.Adapter<CartViewHolder>() {

    private val basketList = arrayListOf<Basket>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            ItemCartBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(basketList[position])
    }

    override fun getItemCount(): Int {
        return basketList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Basket>) {
        basketList.clear()
        basketList.addAll(list)
        notifyDataSetChanged()
    }
}