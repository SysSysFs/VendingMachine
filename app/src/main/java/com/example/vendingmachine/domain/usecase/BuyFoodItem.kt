package com.example.vendingmachine.domain.usecase

import com.example.vendingmachine.common.Resource
import com.example.vendingmachine.domain.model.FoodItem
import com.example.vendingmachine.domain.model.MoneyUnitType
import com.example.vendingmachine.domain.model.TransactionInfo

class BuyFoodItem() {
    operator fun invoke(
        moneyUnitType: MoneyUnitType,
        foodItem: FoodItem
    ): Resource<TransactionInfo> {
        val transactionInfo = TransactionInfo(
            moneyUnitType = moneyUnitType,
            foodItem = foodItem
        )

        return if (transactionInfo.change < 0) {
            Resource.Error(message = "inserted money is not sufficient to do this transaction")
        } else if (transactionInfo.foodItem.stock == 0) {
            Resource.Error(message = "stock for this item is not available")
        } else {
            Resource.Success(data = transactionInfo)
        }
    }
}