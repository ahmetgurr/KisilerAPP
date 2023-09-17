package com.example.kisileruygulamasmvvm.di

import com.example.kisileruygulamasmvvm.data.repo.KisilerDaRepostory
import com.example.kisileruygulamasmvvm.retrofit.ApiUtils
import com.example.kisileruygulamasmvvm.retrofit.KisilerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideKisilerDaRepository(kdao: KisilerDao) : KisilerDaRepostory{
        return KisilerDaRepostory(kdao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao() : KisilerDao{
        return ApiUtils.getKisilerDao()
    }
}