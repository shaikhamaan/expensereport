package com.nelkinda.training

import java.util.Date

enum class ExpenseType {
    DINNER, BREAKFAST, CAR_RENTAL
}

class Expense {
    lateinit var type: ExpenseType
    var amount: Int = 0
}

class ExpenseReport {
    fun printReport(expenses: List<Expense>): String {
        var total = 0
        var mealExpenses = 0
        var report = ""

        report += "Expenses ${Date()}"

        for (expense in expenses) {
            if (expense.type == ExpenseType.DINNER || expense.type == ExpenseType.BREAKFAST) {
                mealExpenses += expense.amount
            }

            var expenseName = ""
            when (expense.type) {
                ExpenseType.DINNER -> expenseName = "Dinner"
                ExpenseType.BREAKFAST -> expenseName = "Breakfast"
                ExpenseType.CAR_RENTAL -> expenseName = "Car Rental"
            }

            val mealOverExpensesMarker =
                if (expense.type == ExpenseType.DINNER && expense.amount > 5000 || expense.type == ExpenseType.BREAKFAST && expense.amount > 1000) "X" else " "

            report += "\n" + expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker

            total += expense.amount
        }

        report += "\nMeal expenses: $mealExpenses"
        report += "\nTotal expenses: $total"

        println(report)
        return report
    }

    fun calculateMealExpense(expenses: List<Expense>): Int {
        var mealExpenses = 0
        for (expense in expenses) {
            if (expense.type == ExpenseType.DINNER || expense.type == ExpenseType.BREAKFAST) {
                mealExpenses += expense.amount
            }
        }
        return mealExpenses
    }
}
