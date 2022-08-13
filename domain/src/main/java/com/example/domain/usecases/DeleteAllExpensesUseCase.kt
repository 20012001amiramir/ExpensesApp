package com.example.domain.usecases

import com.example.domain.repository.Repository

class DeleteAllExpensesUseCase(private val repository: Repository) {

    suspend fun execute() {
        repository.deleteAll()
    }
}