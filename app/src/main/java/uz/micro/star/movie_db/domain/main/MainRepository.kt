package uz.micro.star.movie_db.domain.main

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow
import uz.micro.star.movie_db.data.base.BaseNetworkResult
import uz.micro.star.movie_db.data.main.model.local.MovieResultDto
import uz.micro.star.movie_db.data.main.model.remote.response.MovieResult
import uz.micro.star.movie_db.data.main.model.remote.response.MoviesResponse

interface MainRepository {
    suspend fun getAllNewMovies(): Flow<BaseNetworkResult<List<MovieResultDto>>>
     fun getAllNewMoviesRx(): LiveData<BaseNetworkResult<List<MovieResult>>>
}