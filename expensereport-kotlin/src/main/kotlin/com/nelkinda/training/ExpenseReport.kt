package com.nelkinda.training

import java.util.Date

enum class ExpenseType(val expenseName: String) {
    DINNER("Dinner"),
    BREAKFAST("Breakfast"),
    CAR_RENTAL("Car Rental")
}

class Expense {
    lateinit var type: ExpenseType
    var amount: Int = 0
}

class ExpenseReport {
    fun generateReport(expenses: List<Expense>): String {
        var report = ""
        report += "Expenses ${Date()}"
        report += getAllExpensesWithAmountAndLimitMark(expenses)

        val mealExpenses = calculateMealExpense(expenses)
        report += "\nMeal expenses: $mealExpenses"

        val total = getTotalExpense(expenses)
        report += "\nTotal expenses: $total"

        return report
    }

    private fun getAllExpensesWithAmountAndLimitMark(expenses: List<Expense>): String {
        var expenseDetails = ""
        for (expense in expenses) {
            val expenseName = expense.type.expenseName
            val mealOverExpensesMarker = markExpense(expense)
            expenseDetails += "\n" + expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker
        }
        return expenseDetails
    }


    fun printReport(expenses: List<Expense>) {
        val report = generateReport(expenses)
        println(report)
    }

    fun markExpense(expense: Expense): String =
        if (expense.type == ExpenseType.DINNER && expense.amount > 5000 || expense.type == ExpenseType.BREAKFAST && expense.amount > 1000) {
            "X"
        } else  " "


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
