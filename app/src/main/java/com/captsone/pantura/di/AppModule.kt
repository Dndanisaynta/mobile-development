package com.captsone.pantura.di

import android.content.Context
import com.captsone.pantura.ml.ML
import com.captsone.pantura.network.impl.LaporanRepositoryImpl
import com.captsone.pantura.network.repository.LaporanRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLaporanRepository(): LaporanRepository {
        return LaporanRepositoryImpl()
    }
    @Provides
    @Singleton
    fun provideTensorModel(@ApplicationContext context: Context): ML{
        return ML.newInstance(context)
    }
}