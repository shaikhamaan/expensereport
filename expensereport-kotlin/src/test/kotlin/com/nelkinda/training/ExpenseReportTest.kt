package com.nelkinda.training

import org.junit.jupiter.api.Test

class ExpenseReportTest {


    @Test
    fun `it should print report`() {
        val breakfastExpenseOne = Expense()
        breakfastExpenseOne.amount = 1000
        breakfastExpenseOne.type = ExpenseType.BREAKFAST

        val breakfastExpenseTwo = Expense()
        breakfastExpenseTwo.amount = 1000
        breakfastExpenseTwo.type = ExpenseType.BREAKFAST

        val dinnerExpense = Expense()
        dinnerExpense.amount = 3000
        dinnerExpense.type = ExpenseType.DINNER

        val expenses: List<Expense> = listOf(breakfastExpenseOne, breakfastExpenseTwo, dinnerExpense)

        val expenseReport = ExpenseReport()

        expenseReport.printReport(expenses)
    }
}