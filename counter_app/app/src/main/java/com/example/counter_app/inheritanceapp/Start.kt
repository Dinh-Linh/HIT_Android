package com.example.counter_app.inheritanceapp

fun main(){
    val obj1 = BaseClass()
    obj1.coreValues()
    val obj2 = Secondary()
    obj2.coreValues()

    val obj3 = Offspring()
    obj3.archery()
    obj3.bye()
}