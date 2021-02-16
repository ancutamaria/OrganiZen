package com.amg.organizen.model.di
import android.content.Context
import androidx.room.Room
import com.amg.organizen.model.data.db.OrganiZenDatabase
import com.amg.organizen.model.data.db.QuoteDao
import com.amg.organizen.model.repository.MyRepository
import com.amg.organizen.model.repository.rest.MyAPIService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    fun provideQuoteDao(organiZenDatabase: OrganiZenDatabase): QuoteDao{
        return organiZenDatabase.quotesDao()
    }

    @Provides
    @Singleton
    fun provideOrganiZenDatabase(@ApplicationContext appContext: Context): OrganiZenDatabase {
        return Room.databaseBuilder(
                appContext,
                OrganiZenDatabase::class.java,
                "RssReader"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMyRepository(apiService: MyAPIService, quoteDao: QuoteDao ) = MyRepository(apiService, quoteDao)

}