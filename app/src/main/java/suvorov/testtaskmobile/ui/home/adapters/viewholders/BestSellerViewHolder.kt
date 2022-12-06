package suvorov.testtaskmobile.ui.home.adapters.viewholders

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import suvorov.testtaskmobile.R
import suvorov.testtaskmobile.domain.model.BestSeller
import suvorov.testtaskmobile.databinding.ItemBestSellerBinding
import suvorov.testtaskmobile.ui.home.adapters.clicklistener.PhoneClickListener
import suvorov.testtaskmobile.util.homeDollarString
import suvorov.testtaskmobile.util.setImage

class BestSellerViewHolder(
    private val binding: ItemBestSellerBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(model: BestSeller, phoneClickListener: PhoneClickListener) {
        binding.apply {
            pictureImageView.setImage(model.picture)
            favoriteImageView.setImageResource(
                if (model.isFavorites) R.drawable.favorite
                else R.drawable.favorite_border
            )
            priceWithoutDiscountTextView.text = model.priceWithoutDiscount.homeDollarString()
            discountPriceTextView.text = model.discountPrice.homeDollarString()
            discountPriceTextView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            titleTextView.text = model.title

            root.setOnClickListener {
                phoneClickListener.onPhoneClick()
            }
        }
    }
}