package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpensesDao {
    @Query("SELECT * FROM expenses_table")
    fun getAllExpenses(): List<ExpenseModel>
    @Insert
    fun insert(expenseModel: ExpenseModel)
    @Query("DELETE FROM expenses_table")
    fun deleteAllExpenses()
}