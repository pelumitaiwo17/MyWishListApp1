package com.example.mywishlistapp1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0L,
    @ColumnInfo(name = "wish-title")
    var title: String = "",
    @ColumnInfo(name = "wish-desc")
    var description: String = ""
)
