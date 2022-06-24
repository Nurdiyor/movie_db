package uz.micro.star.movie_db.domain.main

import kotlinx.coroutines.flow.Flow
import uz.micro.star.movie_db.data.base.BaseNetworkResult
import uz.micro.star.movie_db.data.main.model.local.MovieResultDto
import javax.inject.Inject

class MainUseCase @Inject constructor(private val mainRepository: MainRepository) {

    suspend fun getAllNewMovies(): Flow<BaseNetworkResult<List<MovieResultDto>>> {
        return mainRepository.getAllNewMovies()
    }
}