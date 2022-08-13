package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ExpenseModel::class], version = 1)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun getDao(): ExpensesDao
}