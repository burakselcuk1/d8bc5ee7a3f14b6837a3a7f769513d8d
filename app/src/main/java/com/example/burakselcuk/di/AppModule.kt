package com.example.burakselcuk.di

import android.content.Context
import androidx.room.Room
import com.example.burakselcuk.Util.Cons.BASE_URL
import com.example.burakselcuk.db.StationDB
import com.example.burakselcuk.service.ShipApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit): ShipApi{
        return retrofit.create(ShipApi::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideStationDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, StationDB::class.java,
        "station_data"
    ).build()

    @Singleton
    @Provides
    fun provideStationDao(
        db: StationDB
    ) = db.FavoriteDao()


}