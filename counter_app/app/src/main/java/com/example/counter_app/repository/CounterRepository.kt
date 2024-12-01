package com.example.counter_app.repository

import com.example.counter_app.model.CounterModel

class CounterRepository {
    private var _counter = CounterModel(0)

    fun getCounter() = _counter

    fun minus(){
        _counter.count--
    }

    fun plus(){
        _counter.count++
    }

}