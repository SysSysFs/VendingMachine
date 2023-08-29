package com.example.vendingmachine.domain.usecase

import com.example.vendingmachine.domain.model.FoodItem

class GetFoodItemList() {
    operator fun invoke(): List<FoodItem> {
        return listOf(
            FoodItem.Biskuit,
            FoodItem.Chips,
            FoodItem.Oreo,
            FoodItem.Tango,
            FoodItem.Cokelat
        )
    }
}