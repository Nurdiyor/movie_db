package uz.micro.star.movie_db.data.main.model.remote.response


import com.google.gson.annotations.SerializedName
import uz.micro.star.movie_db.data.main.model.remote.response.MovieResult

data class MoviesResponse(
    @SerializedName("results")
    var results: List<MovieResult>,
)