package com.example.counter_app.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.counter_app.repository.CounterRepository

class CounterViewModel() : ViewModel() {
    private val counterRepository: CounterRepository = CounterRepository()
    private val _count = mutableStateOf(counterRepository.getCounter().count)
    val count: MutableState<Int> = _count

    fun plus(){
        counterRepository.plus()
        _count.value = counterRepository.getCounter().count
    }

    fun minus(){
        counterRepository.minus()
        _count.value = counterRepository.getCounter().count
    }

}