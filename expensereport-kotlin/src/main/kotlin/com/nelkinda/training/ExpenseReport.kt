package com.nelkinda.training

import java.util.Date

class ExpenseReport {
    fun generateReport(expenses: List<Expense>): String {
        var report = ""
        report += "Expenses ${Date()}"
        report += exportAllExpenses(expenses)

        val mealExpenses = calculateMealExpense(expenses)
        report += "\nMeal expenses: $mealExpenses"

        val total = getTotalExpense(expenses)
        report += "\nTotal expenses: $total"

        return report
    }

    private fun exportAllExpenses(expenses: List<Expense>): String {
        var expenseDetails = ""
        for (expense in expenses) {
            expenseDetails += "\n" + expense.export()
        }
        return expenseDetails
    }


    fun printReport(expenses: List<Expense>) {
        val report = generateReport(expenses)
        println(report)
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

    private fun getTotalExpense(expenses: List<Expense>): Int {
        var total = 0
        for (expense in expenses) total += expense.amount
        return total
    }

}
