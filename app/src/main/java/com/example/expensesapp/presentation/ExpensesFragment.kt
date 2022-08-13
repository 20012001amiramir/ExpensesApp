package com.example.expensesapp.presentation

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.ColorFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.expensesapp.R
import com.example.expensesapp.adapter.ExpensesAdapter
import com.example.expensesapp.const.mainActivity
import com.example.expensesapp.databinding.FragmentExpensesBinding
import com.example.expensesapp.viewmodels.ExpensesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpensesFragment : Fragment() {
    private lateinit var binding: FragmentExpensesBinding
    private val adapter = ExpensesAdapter()
    private val vm: ExpensesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExpensesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //
        binding.addBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_expensesFragment_to_addFragment)
            mainActivity.binding.tvTop.text = "Add expense"
        }
        binding.deleteAllBtn.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
                .setTitle("Alert!")
                .setMessage("Do you really want to delete all expenses?")
                .setPositiveButton("Yes") { dialogInterface, someInt ->
                    vm.deleteAllExpenses()
                    vm.setExpensesList()
                }
                .setNegativeButton("No") { dialogInterface, someInt ->
                    dialogInterface.cancel()
                }
                .create()
            dialog.show()
            val positiveBtn = dialog.getButton(DialogInterface.BUTTON_POSITIVE)
            val negativeBtn = dialog.getButton(DialogInterface.BUTTON_NEGATIVE)
            positiveBtn.setBackgroundColor(resources.getColor(R.color.black))
            negativeBtn.setBackgroundColor(resources.getColor(R.color.black))
        }
        binding.rcView.adapter = adapter
        vm.expensesList.observe(viewLifecycleOwner) {
            adapter.submitList(it.asReversed())
        }
        vm.setExpensesList()
    }
}