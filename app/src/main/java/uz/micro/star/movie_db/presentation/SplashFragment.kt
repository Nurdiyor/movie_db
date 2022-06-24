package uz.micro.star.movie_db.presentation

import android.os.CountDownTimer
import uz.micro.star.movie_db.R
import uz.micro.star.movie_db.databinding.FragmentSplashBinding


class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun onViewCreate() {
        object : CountDownTimer(3000, 100) {
            override fun onFinish() {
                navController.navigate(R.id.action_splashFragment_to_mainFragment)
            }

            override fun onTick(value: Long) {

            }
        }.start()
    }

}