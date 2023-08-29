package com.example.vendingmachine.usecase

import com.example.vendingmachine.common.Resource
import com.example.vendingmachine.domain.model.FoodItem
import com.example.vendingmachine.domain.model.MoneyUnitType
import com.example.vendingmachine.domain.model.TransactionInfo
import com.example.vendingmachine.domain.usecase.BuyFoodItem
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BuyFoodItemListUnitTest {
    private lateinit var buyFoodItem: BuyFoodItem

    @Before
    fun setUp() {
        buyFoodItem = BuyFoodItem()
    }

    @Test
    fun `inserted money is not sufficient`() {
        val result = buyFoodItem(
            moneyUnitType = MoneyUnitType.TWOTHOUSAND,
            foodItem = FoodItem.Biskuit
        )

        Assert.assertTrue(result is Resource.Error)
        Assert.assertEquals(
            result.message,
            "inserted money is not sufficient to do this transaction"
        )
    }

    @Test
    fun `insufficient stock`() {
        val result = buyFoodItem(
            moneyUnitType = MoneyUnitType.TENTHOUSAND,
            foodItem = FoodItem.Chips
        )

        Assert.assertTrue(result is Resource.Error)
        Assert.assertEquals(
            result.message,
            "stock for this item is not available"
        )
    }

    @Test
    fun `transaction succeed`() {
        val result = buyFoodItem(
            moneyUnitType = MoneyUnitType.FIFTYTHOUSAND,
            foodItem = FoodItem.Biskuit
        )

        Assert.assertTrue(result is Resource.Success)
    }
}