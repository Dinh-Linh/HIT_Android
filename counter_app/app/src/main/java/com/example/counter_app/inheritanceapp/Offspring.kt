package com.example.counter_app.inheritanceapp

class Offspring : BaseClass(), Archery, Goodbye {
    override fun archery() {
        super.archery()
        println("This is archery and hello world")
    }

    override fun bye() {
        super.bye()
        println("This is a singer and sing goodbye word")
    }
}