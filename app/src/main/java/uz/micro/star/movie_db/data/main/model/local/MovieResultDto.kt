package uz.micro.star.movie_db.data.main.model.local

data class MovieResultDto(
    var adult: Boolean,
    var backdropPath: String,
    var genreIds: List<Int>,
    var id: Long,
    var originalLanguage: String,
    var originalTitle: String,
    var overview: String,
    var popularity: Double,
    var posterPath: String,
    var releaseDate: String,
    var title: String,
    var video: Boolean,
    var voteAverage: Double,
    var voteCount: Int
)