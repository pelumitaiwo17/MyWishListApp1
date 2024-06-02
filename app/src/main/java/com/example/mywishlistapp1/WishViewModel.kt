package com.example.mywishlistapp1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywishlistapp.Graph
import com.example.mywishlistapp.WishRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(private val wishRepository: WishRepository = Graph.wishRepository) :
    ViewModel() {

    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    var isValidUpdate = false

    lateinit var getAllWishes: Flow<List<Wish>>


    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWishes()
        }

    }

    fun onWishTitleChange(newString: String) {
        wishTitleState = newString
    }

    fun onWishDescriptionChanged(newString: String) {
        wishDescriptionState = newString
    }


    fun addWishes(wish: Wish) {
        isValidUpdate = wish.title.isNotEmpty()
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addWish(wish = wish)


        }

    }

    fun getAWishById(id: Long): Flow<Wish> {
        return wishRepository.getAWishById(id)
    }

    fun updateWishes(wish: Wish) {
        var isValidUpdate = false
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateAWish(wish = wish)
        }
    }


    fun deleteAWish(wish: Wish) {
        viewModelScope.launch {
            wishRepository.deleteAWish(wish= wish)
        }
    }
}