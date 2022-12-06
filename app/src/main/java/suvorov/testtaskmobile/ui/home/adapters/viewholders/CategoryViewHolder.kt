package suvorov.testtaskmobile.ui.home.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import suvorov.testtaskmobile.databinding.ItemCategoryBinding
import suvorov.testtaskmobile.ui.home.adapters.model.Category

class CategoryViewHolder(
    private val binding: ItemCategoryBinding
): RecyclerView.ViewHolder(binding.root) {

    val card = binding.categoryCardView
    val image = binding.categoryImageView
    val title = binding.categoryTextView

    fun bind(model: Category) {
        binding.apply {
            categoryImageView.setImageResource(model.image)
            categoryTextView.setText(model.title)
        }
    }
}