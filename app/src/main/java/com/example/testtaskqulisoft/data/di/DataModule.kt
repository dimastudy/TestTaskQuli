package com.example.testtaskqulisoft.data.di

import com.example.testtaskqulisoft.data.PhotosRepository
import com.example.testtaskqulisoft.data.network.CloudDataSource
import com.example.testtaskqulisoft.data.network.PhotosCloudDataSource
import com.example.testtaskqulisoft.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindCloudDataSource(dataSource: PhotosCloudDataSource) : CloudDataSource

    @Binds
    @Singleton
    abstract fun bindRepository(repository: PhotosRepository) : Repository




}