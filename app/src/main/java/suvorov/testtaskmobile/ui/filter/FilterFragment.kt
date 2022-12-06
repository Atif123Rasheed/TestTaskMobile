package suvorov.testtaskmobile.ui.filter

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import suvorov.testtaskmobile.R
import suvorov.testtaskmobile.databinding.FragmentFilterBinding
import suvorov.testtaskmobile.ui.base.BaseBottomSheetDialogFragment
import suvorov.testtaskmobile.ui.base.SharedViewModel
import suvorov.testtaskmobile.util.PriceHelper.getPriceRange

class FilterFragment:
    BaseBottomSheetDialogFragment<FragmentFilterBinding>(
    FragmentFilterBinding::inflate
) {
    private val sharedViewModel: SharedViewModel by activityViewModel()
    private val preferences: SharedPreferences by inject()
    companion object {
        const val BRAND_POSITION = "Brand position"
        const val PRICE_POSITION = "Price position"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
        initBrandsSpinner()
        initPriceSpinner()
        loadData()
    }

    private fun initClickListener() {
        binding.backCardView.setOnClickListener {
            dismiss()
        }
        binding.doneButton.setOnClickListener {
            dismiss()
        }
    }

    private fun initBrandsSpinner() {
        ArrayAdapter.createFromResource(
            requireContext(), R.array.brands, R.layout.item_spinner).also {
            it.setDropDownViewResource(R.layout.item_dropdown_spinner)
            binding.brandSpinner.adapter = it
        }
        binding.brandSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //сохранение позиции BrandSpinner
                preferences.edit().putInt(BRAND_POSITION, position).apply()
                //сохранение значения BrandSpinner для передачи в HomeFragment()
                val brand = resources.getStringArray(R.array.brandsList)[position]
                sharedViewModel.saveBrand(brand)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun initPriceSpinner() {
        ArrayAdapter.createFromResource(
            requireContext(), R.array.pricesList, R.layout.item_spinner).also {
            it.setDropDownViewResource(R.layout.item_dropdown_spinner)
            binding.priceSpinner.adapter = it
        }
        binding.priceSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //сохранение позиции PriceSpinner
                preferences.edit().putInt(PRICE_POSITION, position).apply()
                //сохранение значения PriceSpinner для передачи в HomeFragment()
                val priceRange = getPriceRange(resources.getStringArray(R.array.pricesList)[position])
                sharedViewModel.savePriceRange(priceRange)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun loadData() {
        binding.brandSpinner.setSelection(preferences.getInt(BRAND_POSITION, 0))
        binding.priceSpinner.setSelection(preferences.getInt(PRICE_POSITION, 0))
    }
}