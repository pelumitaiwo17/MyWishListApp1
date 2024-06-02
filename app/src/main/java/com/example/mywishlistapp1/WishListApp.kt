package com.example.mywishlistapp1

import android.app.Application
import com.example.mywishlistapp.Graph

class WishListApp: Application() {
    override fun onCreate(){
        super.onCreate()
        Graph.provide(this)
    }
}