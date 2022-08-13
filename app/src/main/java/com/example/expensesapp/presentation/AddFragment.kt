package com.example.expensesapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.expensesapp.R
import com.example.expensesapp.const.mainActivity
import com.example.expensesapp.databinding.FragmentAddBinding
import com.example.expensesapp.viewmodels.AddViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private val vm: AddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //
        binding.addExpenseBtn.setOnClickListener {
            val sum = binding.editExpense.text.toString().toInt()
            val rbId = binding.radioGroup.checkedRadioButtonId
            var category: String = ""
            when (rbId) {
                R.id.rbFood -> category = "Food"
                R.id.rbTransportation -> category = "Transportation"
                R.id.rbHealthcare -> category = "Healthcare"
                R.id.rbClothes -> category = "Clothes"
                R.id.rbEntertainment -> category = "Entertainment"
                R.id.rbOther -> category = "Other"
            }
            vm.insertExpense(sum, category)
            Navigation.findNavController(view).navigate(R.id.action_addFragment_to_expensesFragment)
            mainActivity.binding.tvTop.text = "Your expenses"
        }
    }
}