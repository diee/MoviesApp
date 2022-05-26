package com.alarconsoft.moonshottrainning.app

import com.alarconsoft.moonshottrainning.app.data.MovieNetworkDataSource
import com.alarconsoft.moonshottrainning.app.data.MoviesApi
import com.alarconsoft.moonshottrainning.data.MoviesRepository
import com.alarconsoft.moonshottrainning.data.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(logging).build()
    }

    @Provides
    @Singleton
    fun provideMoviesApi(okHttpClient: OkHttpClient): MoviesApi {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(MoviesApi::class.java)
    }

    @Provides
    fun provideMoviesNetworkDataSource(api: MoviesApi): RemoteDataSource {
        return MovieNetworkDataSource(api)
    }

    @Provides
    fun provideMoviesRepository(dataSource: RemoteDataSource): MoviesRepository {
        return MoviesRepository(dataSource)
    }
}