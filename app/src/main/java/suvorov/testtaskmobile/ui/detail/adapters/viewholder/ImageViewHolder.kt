package suvorov.testtaskmobile.ui.detail.adapters.viewholder

import androidx.recyclerview.widget.RecyclerView
import suvorov.testtaskmobile.databinding.ItemDetailImageBinding
import suvorov.testtaskmobile.util.setImage

class ImageViewHolder(
    private val binding: ItemDetailImageBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(model: String) {
        binding.apply {
            binding.imageView.setImage(model)
        }
    }
}