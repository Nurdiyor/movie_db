package uz.micro.star.movie_db.data.main

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.micro.star.movie_db.data.base.BaseNetworkResult
import uz.micro.star.movie_db.data.main.model.local.MovieResultDto
import uz.micro.star.movie_db.domain.main.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val serviceApi: MainService) : MainRepository {
    override suspend fun getAllNewMovies(): Flow<BaseNetworkResult<List<MovieResultDto>>> {
        return flow {
            emit(BaseNetworkResult.Loading(true))
            val response = serviceApi.getAllNewMovies()
            emit(BaseNetworkResult.Loading(false))
            if (response.code() == 200) {
                emit(BaseNetworkResult.Success(response.body()!!.results.map {
                    MovieResultDto(
                        adult = it.adult,
                        title = it.title,
                        id = it.id,
                        backdropPath = it.backdropPath,
                        genreIds = it.genreIds,
                        originalLanguage = it.originalLanguage,
                        originalTitle = it.originalTitle,
                        overview = it.overview,
                        popularity = it.popularity,
                        posterPath = it.posterPath,
                        releaseDate = it.releaseDate,
                        video = it.video,
                        voteAverage = it.voteAverage,
                        voteCount = it.voteCount
                    )
                }))
            } else {
                emit(BaseNetworkResult.Error("Xatolik"))
            }
        }
    }
}