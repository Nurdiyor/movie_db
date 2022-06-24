package uz.micro.star.movie_db.presentation.main

import android.util.Log
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.micro.star.movie_db.databinding.MainFragmentBinding
import uz.micro.star.movie_db.presentation.BaseFragment

@AndroidEntryPoint
class MainFragment : BaseFragment<MainFragmentBinding>(MainFragmentBinding::inflate) {
    val viewModel: MainViewModel by viewModels()
    override fun onViewCreate() {

        viewModel.isLoadingLiveData.observe(viewLifecycleOwner) {

        }
        viewModel.moviesListLiveData.observe(viewLifecycleOwner) {
            it.forEach { movie ->
                Log.d("HHHH", "onViewCreate: ${movie.originalTitle}")
            }

        }
        viewModel.getAllNewMovies()
    }
}