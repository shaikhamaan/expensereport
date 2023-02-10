package com.nelkinda.training

class Expense(var amount: Int, var type: ExpenseType) {

    companion object {
        const val MAX_DINNER_LIMIT = 5000
        const val MAX_BREAKFAST_LIMIT = 1000
    }

    fun markExpense(): String =
        if (type == ExpenseType.DINNER && amount > MAX_DINNER_LIMIT || type == ExpenseType.BREAKFAST && amount > MAX_BREAKFAST_LIMIT) {
            "X"
        } else " "
}