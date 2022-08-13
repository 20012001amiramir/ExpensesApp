package com.example.expensesapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetStatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatsViewModel @Inject constructor(
    private val getStatsUseCase: GetStatsUseCase
) : ViewModel() {

    val allExpensesSum = MutableLiveData<Int>()

    val foodSum = MutableLiveData<Int>(0)
    val transportationSum = MutableLiveData<Int>(0)
    val healthcareSum = MutableLiveData<Int>(0)
    val clothesSum = MutableLiveData<Int>(0)
    val entertainmentSum = MutableLiveData<Int>(0)
    val otherSum = MutableLiveData<Int>(0)

    fun setStats() {
        viewModelScope.launch(Dispatchers.IO) {
            val expensesList = getStatsUseCase.execute()
            //
            var allExpensesSumInt = 0
            var foodSumInt = 0
            var transportationSumInt = 0
            var healthcareSumInt = 0
            var clothesSumInt = 0
            var entertainmentSumInt = 0
            var otherSumInt = 0
            //
            expensesList.forEach {
                allExpensesSumInt += it.expense
                when (it.category) {
                    "Food" -> {
                        foodSumInt += it.expense
                    }
                    "Transportation" -> {
                        transportationSumInt += it.expense
                    }
                    "Healthcare" -> {
                        healthcareSumInt += it.expense
                    }
                    "Clothes" -> {
                        clothesSumInt += it.expense
                    }
                    "Entertainment" -> {
                        entertainmentSumInt += it.expense
                    }
                    "Other" -> {
                        otherSumInt += it.expense
                    }
                }
            }
            allExpensesSum.postValue(allExpensesSumInt)
            foodSum.postValue(foodSumInt)
            transportationSum.postValue(transportationSumInt)
            healthcareSum.postValue(healthcareSumInt)
            clothesSum.postValue(clothesSumInt)
            entertainmentSum.postValue(entertainmentSumInt)
            otherSum.postValue(otherSumInt)
        }
    }
}