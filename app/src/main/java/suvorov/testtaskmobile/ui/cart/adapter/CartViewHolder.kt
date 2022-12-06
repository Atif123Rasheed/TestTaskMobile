package suvorov.testtaskmobile.ui.cart.adapter

import androidx.recyclerview.widget.RecyclerView
import suvorov.testtaskmobile.domain.model.Basket
import suvorov.testtaskmobile.databinding.ItemCartBinding
import suvorov.testtaskmobile.util.cartDollarString
import suvorov.testtaskmobile.util.setImage

class CartViewHolder(private val binding: ItemCartBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(model: Basket) {
        binding.apply {
            imageView.setImage(model.images)
            titleTextView.text = model.title
            priceTextView.text = model.price.cartDollarString()
        }
    }
}