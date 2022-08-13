package com.example.expensesapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.expensesapp.databinding.FragmentStatsBinding
import com.example.expensesapp.viewmodels.StatsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatsFragment : Fragment() {
    private lateinit var binding: FragmentStatsBinding
    private val vm: StatsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //
        vm.allExpensesSum.observe(viewLifecycleOwner) {
            binding.tvSumOfAllExpenses.text = "$it rub."
        }
        vm.foodSum.observe(viewLifecycleOwner) {
            binding.tvFood.text = "$it rub."
        }
        vm.transportationSum.observe(viewLifecycleOwner) {
            binding.tvTransportation.text = "$it rub."
        }
        vm.healthcareSum.observe(viewLifecycleOwner) {
            binding.tvHealthcare.text = "$it rub."
        }
        vm.clothesSum.observe(viewLifecycleOwner) {
            binding.tvClothes.text = "$it rub."
        }
        vm.entertainmentSum.observe(viewLifecycleOwner) {
            binding.tvEntertainment.text = "$it rub."
        }
        vm.otherSum.observe(viewLifecycleOwner) {
            binding.tvOther.text = "$it rub."
        }
        //
        vm.setStats()
    }
}