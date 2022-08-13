package com.example.expensesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.expensesapp.const.mainActivity
import com.example.expensesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        mainActivity = this
        binding.bottomNav.setOnNavigationItemSelectedListener {
            val navController = Navigation.findNavController(binding.fragmentContainerView)
            when (it.itemId) {
                R.id.menu_expenses -> {
                    navController.navigate(R.id.action_statsFragment_to_expensesFragment)
                    binding.tvTop.text = "Your expenses"
                }
                R.id.menu_stats -> {
                    navController.navigate(R.id.action_expensesFragment_to_statsFragment)
                    binding.tvTop.text = "Stats"
                }
            }
            true
        }
    }
}