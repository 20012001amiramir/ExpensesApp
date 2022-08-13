package com.example.expensesapp.di

import android.content.Context
import androidx.room.Room
import com.example.data.db.ExpenseDatabase
import com.example.data.db.ExpensesDao
import com.example.data.repository.RepositoryImpl
import com.example.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideRepository(expensesDao: ExpensesDao): Repository {
        return RepositoryImpl(expensesDao)
    }
    @Provides
    @Singleton
    fun provideExpensesDao(@ApplicationContext context: Context): ExpensesDao {
        return Room
            .databaseBuilder(context, ExpenseDatabase::class.java, "DB")
            .build()
            .getDao()
    }
}