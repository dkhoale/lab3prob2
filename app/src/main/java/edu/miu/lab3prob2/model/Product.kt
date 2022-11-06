package edu.miu.lab3prob2.model

data class Product(
    val title: String, val price: Double, val color: String,
    val image: Int, val itemId: String, val desc: Int
) : java.io.Serializable
