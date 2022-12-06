package suvorov.testtaskmobile.ui.home.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import suvorov.testtaskmobile.domain.model.HomeStore
import suvorov.testtaskmobile.databinding.ItemHotSalesBinding
import suvorov.testtaskmobile.ui.home.adapters.clicklistener.PhoneClickListener
import suvorov.testtaskmobile.util.setImage

class HotSalesViewHolder(
    private val binding: ItemHotSalesBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(model: HomeStore, phoneClickListener: PhoneClickListener) {
        binding.apply {
            pictureImageView.setImage(model.picture)
            titleTextView.text = model.title
            subtitleTextView.text = model.subtitle
            newCardView.visibility = if(model.isNew) View.VISIBLE else View.GONE

            root.setOnClickListener {
                phoneClickListener.onPhoneClick()
            }
        }
    }
}