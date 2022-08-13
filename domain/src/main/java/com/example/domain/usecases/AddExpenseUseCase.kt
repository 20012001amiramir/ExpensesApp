package com.example.domain.usecases

import com.example.domain.model.ExpenseModelRV
import com.example.domain.repository.Repository

class AddExpenseUseCase(private val repository: Repository) {

    suspend fun execute(sum: Int, category: String) {
        repository.insertExpense(ExpenseModelRV(sum, category))
    }
}