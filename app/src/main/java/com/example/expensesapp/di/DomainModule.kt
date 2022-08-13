package com.example.expensesapp.di

import com.example.domain.repository.Repository
import com.example.domain.usecases.AddExpenseUseCase
import com.example.domain.usecases.DeleteAllExpensesUseCase
import com.example.domain.usecases.GetExpensesListUseCase
import com.example.domain.usecases.GetStatsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideGetExpensesListUseCase(repository: Repository): GetExpensesListUseCase {
        return GetExpensesListUseCase(repository)
    }
    @Provides
    fun provideAddExpenseUseCase(repository: Repository): AddExpenseUseCase {
        return AddExpenseUseCase(repository)
    }
    @Provides
    fun provideGetStatsUseCase(repository: Repository): GetStatsUseCase {
        return GetStatsUseCase(repository)
    }
    @Provides
    fun provideDeleteAllExpensesUseCase(repository: Repository): DeleteAllExpensesUseCase {
        return DeleteAllExpensesUseCase(repository)
    }
}