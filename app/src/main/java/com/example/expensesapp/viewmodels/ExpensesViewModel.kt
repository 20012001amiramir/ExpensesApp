package com.example.expensesapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ExpenseModelRV
import com.example.domain.usecases.DeleteAllExpensesUseCase
import com.example.domain.usecases.GetExpensesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpensesViewModel @Inject constructor(
    private val getExpensesListUseCase: GetExpensesListUseCase,
    private val deleteAllExpensesUseCase: DeleteAllExpensesUseCase
) : ViewModel() {

    val expensesList = MutableLiveData<List<ExpenseModelRV>>()

    fun setExpensesList() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = getExpensesListUseCase.execute()
            expensesList.postValue(list)
        }
    }
    fun deleteAllExpenses() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllExpensesUseCase.execute()
        }
    }
}