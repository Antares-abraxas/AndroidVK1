package com.example.rectlist


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


class MainViewModel(private val state: SavedStateHandle) : ViewModel() {

    companion object {
        private const val ITEMS_KEY = "items"
    }

    private val _items = MutableLiveData(state.get<List<Int>>(ITEMS_KEY) ?: emptyList())
    val items: LiveData<List<Int>> = _items


    fun addItem() {
        val current = _items.value ?: emptyList()
        val nextIndex = current.size + 1
        val updated = current + nextIndex
        _items.value = updated
        state[ITEMS_KEY] = updated
    }
}