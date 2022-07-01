package uz.micro.star.movie_db.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import uz.micro.star.movie_db.data.base.BaseNetworkResult
import uz.micro.star.movie_db.data.main.model.local.MovieResultDto
import uz.micro.star.movie_db.domain.main.MainUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
) : ViewModel() {
    private val movieList = MutableLiveData<List<MovieResultDto>>()
    val moviesListLiveData: LiveData<List<MovieResultDto>> get() = movieList

    private val _isLoadingLiveData = MutableLiveData<Boolean>()
    val isLoadingLiveData: LiveData<Boolean> get() = _isLoadingLiveData

    fun getAllNewMovies() {
        viewModelScope.launch {
            mainUseCase.getAllNewMovies().catch {
                //xatolik beriladi
                Log.d("DDDD", "getServicesResponse: $this")
            }.collect { result ->
                when (result) {
                    is BaseNetworkResult.Success -> {
                        result.data?.let { list ->
                            Log.d("DDDD", "getServicesResponse: $list")
                            movieList.value = list
                        }
                    }
                    is BaseNetworkResult.Error -> {
                        //network error
                        Log.d("DDDD", "getServicesResponse: xatooooooo")
                    }
                    is BaseNetworkResult.Loading -> {
                        //loading
                        result.isLoading?.let {
                            _isLoadingLiveData.value = it
                        }
                    }
                }
            }
        }
    }

    fun getAllNewMoviesRx() {
        mainUseCase.getAllNewMoviesRx().observeForever {
            when (it) {
                is BaseNetworkResult.Loading -> {

                }
                is BaseNetworkResult.Success -> {
//                    movieList.value = it.data
                    Log.d("DDDD", "getAllNewMoviesRx: ${it.data}")
                }
                is BaseNetworkResult.Error -> {

                }
            }
        }
    }
}