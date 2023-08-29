package com.example.vendingmachine.domain.model

data class TransactionInfo(
    val moneyUnitType: MoneyUnitType,
    val foodItem: FoodItem
) {
    val change: Double
        get() {
            return moneyUnitType.value - foodItem.price
        }
}