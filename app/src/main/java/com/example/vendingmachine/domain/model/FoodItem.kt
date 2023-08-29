package com.example.vendingmachine.domain.model

sealed class FoodItem(
    val name: String,
    val price: Double,
    val stock: Int
) {
    object Biskuit : FoodItem(
        name = "Biskuit",
        price = 6000.0,
        stock = 10
    )

    object Chips : FoodItem(
        name = "Chips",
        price = 8000.0,
        stock = 0
    )

    object Oreo : FoodItem(
        name = "Oreo",
        price = 10000.0,
        stock = 10
    )

    object Tango : FoodItem(
        name = "Tango",
        price = 12000.0,
        stock = 10
    )

    object Cokelat : FoodItem(
        name = "Cokelat",
        price = 15000.0,
        stock = 10
    )
}