package com.example.domain.repository

import com.example.domain.model.ExpenseModelRV

interface Repository {
    fun getExpenses(): List<ExpenseModelRV>
    fun insertExpense(expModelRV: ExpenseModelRV)
    fun deleteAll()
}