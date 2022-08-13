package com.example.domain.usecases

import com.example.domain.model.ExpenseModelRV
import com.example.domain.repository.Repository

class GetExpensesListUseCase(
    private val repository: Repository
) {

    suspend fun execute(): List<ExpenseModelRV> {
        return repository.getExpenses()
    }
}