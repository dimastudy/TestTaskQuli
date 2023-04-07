package com.example.testtaskqulisoft.data.di

import com.example.testtaskqulisoft.data.mappers.PhotoDataToDomainMapper
import com.example.testtaskqulisoft.data.mappers.ResultNetworkToPhotoDataMapper
import com.example.testtaskqulisoft.domain.mappers.BasePhotoDataToDomainMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class MappersModule {

    @Binds
    @Singleton
    abstract fun bindPhotoDataToDomainMapper(mapper: BasePhotoDataToDomainMapper): PhotoDataToDomainMapper

    @Binds
    @Singleton
    abstract fun bindResultNetworkToDataMapper(mapper: ResultNetworkToPhotoDataMapper.Base) : ResultNetworkToPhotoDataMapper



}