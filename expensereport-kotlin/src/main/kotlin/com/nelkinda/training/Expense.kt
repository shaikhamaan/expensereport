package com.nelkinda.training

class Expense(var amount: Int, var type: ExpenseType, var limitStatus: String = "") {
    init {
        markExpense()
    }
    companion object {
        const val MAX_DINNER_LIMIT = 5000
        const val MAX_BREAKFAST_LIMIT = 1000
    }

    fun markExpense() {
        if (type == ExpenseType.DINNER && amount > MAX_DINNER_LIMIT || type == ExpenseType.BREAKFAST && amount > MAX_BREAKFAST_LIMIT) {
            limitStatus = ExpenseLimit.EXCEEDED.mark
            return
        }
        limitStatus = ExpenseLimit.NOT_EXCEEDED.mark
    }
}