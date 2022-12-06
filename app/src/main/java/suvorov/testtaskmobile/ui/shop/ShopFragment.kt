package suvorov.testtaskmobile.ui.shop

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import suvorov.testtaskmobile.R
import suvorov.testtaskmobile.databinding.FragmentShopBinding
import suvorov.testtaskmobile.ui.base.BaseFragment
import suvorov.testtaskmobile.ui.detail.DetailViewModel
import suvorov.testtaskmobile.util.shopDollarString
import suvorov.testtaskmobile.util.doOnChange

class ShopFragment: BaseFragment<FragmentShopBinding>(FragmentShopBinding::inflate) {

    private val viewModel: DetailViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        viewModel.getPhone()
    }

    @SuppressLint("SetTextI18n")
    private fun observeViewModel() {
        viewModel.phone.doOnChange(this) {
            binding.apply {
                cpuTextView.text = it.cpu
                cameraTextView.text = it.camera
                ssdTextView.text = it.ssd
                sdTextView.text = it.sd
                firstColor.setCardBackgroundColor(Color.parseColor(it.color[0]))
                secondColor.setCardBackgroundColor(Color.parseColor(it.color[1]))
                capacityButton.text =
                    "${it.capacity[0]} ${requireContext().getString(R.string.GB)}"
                capacityTextView.text =
                    "${it.capacity[1]} ${requireContext().getString(R.string.gb)}"
                addButton.text =
                    "${requireContext().getString(R.string.add_to_cart)}        ${it.price.shopDollarString()}"
            }
        }
    }
}