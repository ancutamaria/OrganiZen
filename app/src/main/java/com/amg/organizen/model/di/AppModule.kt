package com.amg.organizen.model.di
import com.amg.organizen.model.repository.MyRepository
import com.amg.organizen.model.repository.rest.MyAPIService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonkeeper.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideAPIService(retrofit: Retrofit): MyAPIService = retrofit.create(MyAPIService::class.java)

    @Singleton
    @Provides
    fun provideMarketingRepository( apiService: MyAPIService ) = MyRepository(apiService)
}