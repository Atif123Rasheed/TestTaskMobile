package suvorov.testtaskmobile.ui.cart

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import suvorov.testtaskmobile.R
import suvorov.testtaskmobile.databinding.FragmentCartBinding
import suvorov.testtaskmobile.ui.base.BaseFragment
import suvorov.testtaskmobile.ui.base.SharedViewModel
import suvorov.testtaskmobile.ui.cart.adapter.CartAdapter
import suvorov.testtaskmobile.util.cartDollarString
import suvorov.testtaskmobile.util.doOnChange

class CartFragment: BaseFragment<FragmentCartBinding>(FragmentCartBinding::inflate) {

    private val viewModel: CartViewModel by viewModel()
    private val sharedViewModel: SharedViewModel by activityViewModel()
    private val cartAdapter = CartAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        viewModel.getCart()
        initView()
    }

    @SuppressLint("SetTextI18n")
    private fun observeViewModel() {
        viewModel.cart.doOnChange(this) { cart ->
            cart.basket.let { cartAdapter.updateList(it) }

            binding.totalTextView.text =
                "${cart.total.cartDollarString()} ${requireContext().getString(R.string.us)}"
            binding.deliveryTextView.text = cart.delivery

            //сохранение значения количества товара для передачи в HomeFragment() и в DetailFragment()
            sharedViewModel.saveBasket(cartAdapter.itemCount)
        }

        viewModel.isLoading.doOnChange(this) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

    private fun initView() {
        binding.basketRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cartAdapter
        }

        binding.backCardView.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.checkButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}