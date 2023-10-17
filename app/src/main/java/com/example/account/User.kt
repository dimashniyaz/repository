package com.example.account

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class User(@PrimaryKey(autoGenerate = true) val uid: Int = 0,
                @ColumnInfo(name = "picture") val picture: Int,
                @ColumnInfo(name = "full_name") val full_name: String,
                @ColumnInfo(name = "username") val username: String?,
                @ColumnInfo(name = "password") var password: String?)

