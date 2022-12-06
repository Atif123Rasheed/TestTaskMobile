package suvorov.testtaskmobile.ui.home

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import suvorov.testtaskmobile.R
import suvorov.testtaskmobile.databinding.FragmentHomeBinding
import suvorov.testtaskmobile.ui.home.adapters.model.Category
import suvorov.testtaskmobile.ui.base.BaseFragment
import suvorov.testtaskmobile.ui.filter.FilterFragment
import suvorov.testtaskmobile.ui.home.adapters.BestSellerAdapter
import suvorov.testtaskmobile.ui.home.adapters.CategoryAdapter
import suvorov.testtaskmobile.ui.home.adapters.HotSalesAdapter
import suvorov.testtaskmobile.ui.home.adapters.clicklistener.CategoryClickListener
import suvorov.testtaskmobile.ui.home.adapters.clicklistener.PhoneClickListener
import suvorov.testtaskmobile.ui.base.SharedViewModel
import suvorov.testtaskmobile.util.doOnChange

class HomeFragment:
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    AdapterView.OnItemSelectedListener,
    PhoneClickListener,
    CategoryClickListener
{
    private val viewModel: HomeViewModel by viewModel()
    private val sharedViewModel: SharedViewModel by activityViewModel()
    private val categoryAdapter = CategoryAdapter(this)
    private val hotSalesAdapter = HotSalesAdapter(this)
    private val bestSellerAdapter = BestSellerAdapter(this)
    private var priceRange = 0..0
    private var brand = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        viewModel.getProducts()
        initView()
        initClickListener()
    }

    private fun observeViewModel() {
        //получение списка брендов из FilterFragment()
        sharedViewModel.brand.doOnChange(this) {
            viewModel.getProducts()
            brand = it
        }

        //получение списков диапазонов цен из FilterFragment()
        sharedViewModel.priceRange.doOnChange(this) {
            viewModel.getProducts()
            priceRange = it
        }

        //получения значения количества товара из CartFragment()
        sharedViewModel.basket.doOnChange(this) {
            binding.countCardView.visibility = View.VISIBLE
            binding.countTextView.text = it.toString()
        }

        viewModel.product.doOnChange(this) {
            hotSalesAdapter.updateList(
                requireContext(),
                it.homeStore,
                brand
            )

            bestSellerAdapter.updateList(
                requireContext(),
                it.bestSeller,
                brand,
                priceRange
            )
        }

        viewModel.isLoading.doOnChange(this) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

    private fun initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            requireActivity().window.insetsController?.show(WindowInsets.Type.statusBars())
        }

        //адаптер списка городов
        ArrayAdapter.createFromResource(
            requireContext(), R.array.citiesList, R.layout.item_cities_spinner).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.citiesSpinner.adapter = it
            binding.citiesSpinner.setSelection(2)
        }

        //обновление адаптера категорий товара
        categoryAdapter.updateList()

        //RecyclerView категорий товара
        binding.categoryRecyclerView.apply {
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }

        //RecyclerView "горячих" предложений
        binding.hotSalesRecyclerView.apply {
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.HORIZONTAL, false)
            adapter = hotSalesAdapter
        }

        //RecyclerView бестселлеров
        val bestSellerLayoutManager = GridLayoutManager(context, 2)
        binding.bestSellerRecyclerView.apply {
            layoutManager = bestSellerLayoutManager
            adapter = bestSellerAdapter
        }
    }

    private fun initClickListener() {
        binding.filterImageView.setOnClickListener {
            val filterFragment = FilterFragment()
            filterFragment.show(
                requireActivity().supportFragmentManager, filterFragment.tag)
        }

        binding.basketImageView.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_cartFragment)
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        binding.citiesSpinner.onItemSelectedListener = this
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    override fun onPhoneClick() {
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
    }

    //функция слушателя нажатий на элемент из списка категорий товара
    override fun onCategoryClick(category: Category) {
        if(category.title != R.string.phones) {
            hotSalesAdapter.clearList()
            bestSellerAdapter.clearList()
            binding.apply {
                hotSales.visibility = View.GONE
                bestSeller.visibility = View.GONE
                hotSeeMore.visibility = View.GONE
                bestSeeMore.visibility = View.GONE
            }
        }else {
            viewModel.getProducts()
            binding.apply {
                hotSales.visibility = View.VISIBLE
                bestSeller.visibility = View.VISIBLE
                hotSeeMore.visibility = View.VISIBLE
                bestSeeMore.visibility = View.VISIBLE
            }
        }
    }
}