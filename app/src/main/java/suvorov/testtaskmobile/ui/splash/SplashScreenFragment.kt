package suvorov.testtaskmobile.ui.splash

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowInsets
import androidx.navigation.fragment.findNavController
import suvorov.testtaskmobile.R
import suvorov.testtaskmobile.databinding.FragmentSplashBinding
import suvorov.testtaskmobile.ui.base.BaseFragment

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment: BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            requireActivity().window.insetsController?.hide(WindowInsets.Type.statusBars())
        }
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
        }, 3000)
    }
}