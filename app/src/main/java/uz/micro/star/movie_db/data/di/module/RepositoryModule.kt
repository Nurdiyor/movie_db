package uz.micro.star.movie_db.data.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.micro.star.movie_db.data.main.MainRepositoryImpl
import uz.micro.star.movie_db.data.main.MainService
import uz.micro.star.movie_db.domain.main.MainRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideServiceRepository(mainService: MainService): MainRepository {
        return MainRepositoryImpl(mainService)
    }

//    @Provides
//    fun provideUssdCodesRepository(loginApi: UssdCodesApi): UssdCodesRepository {
//        return UssdCodesRepositoryImpl(loginApi)
//    }

}