package suvorov.testtaskmobile.ui.home.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import suvorov.testtaskmobile.R
import suvorov.testtaskmobile.databinding.ItemCategoryBinding
import suvorov.testtaskmobile.ui.home.adapters.model.Category
import suvorov.testtaskmobile.ui.home.adapters.clicklistener.CategoryClickListener
import suvorov.testtaskmobile.ui.home.adapters.viewholders.CategoryViewHolder

class CategoryAdapter(
    private val categoryClickListener: CategoryClickListener
): RecyclerView.Adapter<CategoryViewHolder>() {

    private val categoriesList = arrayListOf<Category>()
    private var selectedPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val context = holder.itemView.context
        holder.bind(categoriesList[position])

        if(selectedPosition == position) {
            holder.card.setCardBackgroundColor(ContextCompat.getColor(context, R.color.orange))
            holder.image.setColorFilter(ContextCompat.getColor(context, R.color.white))
            holder.title.setTextColor(ContextCompat.getColor(context, R.color.orange))
        } else {
            holder.card.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white))
            holder.image.setColorFilter(ContextCompat.getColor(context, R.color.gray))
            holder.title.setTextColor(ContextCompat.getColor(context, R.color.dark_blue))
        }

        holder.itemView.setOnClickListener {
            categoryClickListener.onCategoryClick(categoriesList[position])
            if(selectedPosition == position) {
                selectedPosition = -1
                notifyDataSetChanged()
            }
            selectedPosition = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList() {
        categoriesList.clear()
        categoriesList.add(Category(R.string.phones, R.drawable.phone))
        categoriesList.add(Category(R.string.computer, R.drawable.computer))
        categoriesList.add(Category(R.string.health, R.drawable.health))
        categoriesList.add(Category(R.string.books, R.drawable.books))
        categoriesList.add(Category(R.string.camera, R.drawable.camera))
        notifyDataSetChanged()
    }
}