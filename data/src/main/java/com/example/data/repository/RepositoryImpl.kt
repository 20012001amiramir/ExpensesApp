package com.example.data.repository

import com.example.data.db.ExpenseModel
import com.example.data.db.ExpensesDao
import com.example.domain.model.ExpenseModelRV
import com.example.domain.repository.Repository

class RepositoryImpl(private val expensesDao: ExpensesDao) : Repository {
    override fun getExpenses(): List<ExpenseModelRV> {
        val listFromDB = expensesDao.getAllExpenses()
        return mapToExpRVList(listFromDB)
    }

    override fun insertExpense(expModelRV: ExpenseModelRV) {
        expensesDao.insert(mapToExpModel(expModelRV))
    }

    override fun deleteAll() {
        expensesDao.deleteAllExpenses()
    }

    fun mapToExpRVList(expModelList: List<ExpenseModel>): List<ExpenseModelRV> {
        val list = ArrayList<ExpenseModelRV>()
        expModelList.forEach {
            list.add(ExpenseModelRV(it.expense, it.category))
        }
        return list
    }
    fun mapToExpModel(expRV: ExpenseModelRV): ExpenseModel {
        return ExpenseModel(expense = expRV.expense, category = expRV.category)
    }
}