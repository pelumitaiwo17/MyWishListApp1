package com.example.mywishlistapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mywishlistapp1.Wish


@Database(
    entities = [Wish::class],
    version = 1,
    exportSchema = false
)
abstract class WishDatabase: RoomDatabase() {
    abstract fun wishDao(): WishDao
}