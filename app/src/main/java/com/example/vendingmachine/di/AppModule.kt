package com.example.vendingmachine.di

import com.example.vendingmachine.domain.model.FoodItem
import com.example.vendingmachine.domain.usecase.BuyFoodItem
import com.example.vendingmachine.domain.usecase.GetFoodItemList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGetFoodItemListUseCase(): GetFoodItemList  {
        return GetFoodItemList()
    }

    @Provides
    @Singleton
    fun provideBuyFoodItemUseCase(): BuyFoodItem  {
        return BuyFoodItem()
    }
}