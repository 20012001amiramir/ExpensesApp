package com.example.expensesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.ExpenseModelRV
import com.example.expensesapp.R
import com.example.expensesapp.databinding.ItemLayoutBinding

class ExpensesAdapter : ListAdapter<ExpenseModelRV, ExpensesAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemLayoutBinding.bind(view)
        fun bind(item: ExpenseModelRV) {
            binding.tvSum.text = "${item.expense} rub."
            binding.tvCategory.text = "Category: ${item.category}"
        }
    }
    class Comparator() : DiffUtil.ItemCallback<ExpenseModelRV>() {
        override fun areItemsTheSame(oldItem: ExpenseModelRV, newItem: ExpenseModelRV): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ExpenseModelRV, newItem: ExpenseModelRV): Boolean {
            return oldItem.equals(newItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}