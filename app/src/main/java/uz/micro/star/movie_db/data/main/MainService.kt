package uz.micro.star.movie_db.data.main

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.micro.star.movie_db.BuildConfig
import uz.micro.star.movie_db.data.main.model.remote.response.MoviesResponse

interface MainService {
    @GET("movie/now_playing")
    suspend fun getAllNewMovies(
        @Query("api_key") closeReason: String = BuildConfig.TOKEN,
    ): Response<MoviesResponse>
}