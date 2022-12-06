package suvorov.testtaskmobile.ui.detail.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import suvorov.testtaskmobile.databinding.ItemDetailImageBinding
import suvorov.testtaskmobile.ui.detail.adapters.viewholder.ImageViewHolder

class ImageAdapter: RecyclerView.Adapter<ImageViewHolder>() {

    private val imagesList = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemDetailImageBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imagesList[position])
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<String>) {
        imagesList.clear()
        imagesList.addAll(list)
        notifyDataSetChanged()
    }
}