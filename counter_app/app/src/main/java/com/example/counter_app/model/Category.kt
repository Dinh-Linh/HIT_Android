package com.example.counter_app.model

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

data class CategoryResponse(val category: List<Category>)
