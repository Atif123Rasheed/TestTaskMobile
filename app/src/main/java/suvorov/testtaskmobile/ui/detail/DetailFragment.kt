package suvorov.testtaskmobile.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import suvorov.testtaskmobile.R
import suvorov.testtaskmobile.databinding.FragmentDetailBinding
import suvorov.testtaskmobile.ui.base.BaseFragment
import suvorov.testtaskmobile.ui.base.CenterDecoration
import suvorov.testtaskmobile.ui.base.CenterZoomManager
import suvorov.testtaskmobile.ui.base.SharedViewModel
import suvorov.testtaskmobile.ui.detail.adapters.ImageAdapter
import suvorov.testtaskmobile.ui.detail.adapters.PageAdapter
import suvorov.testtaskmobile.util.*

class DetailFragment: BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val viewModel: DetailViewModel by viewModel()
    private val sharedViewModel: SharedViewModel by activityViewModel()
    private val imageAdapter = ImageAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        viewModel.getPhone()
        initView()
    }

    @SuppressLint("SetTextI18n")
    private fun observeViewModel() {
        viewModel.phone.doOnChange(this) {
            imageAdapter.updateList(it.images)

            binding.titleTextView.text = it.title
            binding.favoriteImageView.setImageResource(
                if (it.isFavorites) R.drawable.favorite
                else R.drawable.favorite_border
            )

            //логика отображения рейтинга
            when(it.rating) {
                in 1.0..2.0 -> {
                    binding.secondStar.visibility = View.VISIBLE
                }
                in 2.0..3.0 -> {
                    binding.secondStar.visibility = View.VISIBLE
                    binding.thirdStar.visibility = View.VISIBLE
                }
                in 3.0..4.0 -> {
                    binding.secondStar.visibility = View.VISIBLE
                    binding.thirdStar.visibility = View.VISIBLE
                    binding.fourthStar.visibility = View.VISIBLE
                }
                in 4.0..5.0 -> {
                    binding.secondStar.visibility = View.VISIBLE
                    binding.thirdStar.visibility = View.VISIBLE
                    binding.fourthStar.visibility = View.VISIBLE
                    binding.fifthStar.visibility = View.VISIBLE
                }
            }

        }

        //получения значения количества товара из CartFragment()
        sharedViewModel.basket.doOnChange(this) {
            binding.countCardView.visibility = View.VISIBLE
            binding.countTextView.text = it.toString()
        }

        viewModel.isLoading.doOnChange(this) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

    private fun initView() {
        binding.backCardView.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.cartCardView.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_cartFragment)
        }

        binding.imageRecyclerView.apply {
            //отображение видимого элемента в RecyclerView по центру
            addItemDecoration(CenterDecoration(0))
            //увеличение размера видимого элемента в RecyclerView при скроллинге
            layoutManager = CenterZoomManager(requireContext())
            adapter = imageAdapter
        }

        binding.viewPager.adapter = PageAdapter(this)

        binding.tabLayout.setupWithViewPager(binding.viewPager, listOf(
            getString(R.string.shop),
            getString(R.string.details),
            getString(R.string.features))
        )
    }
}