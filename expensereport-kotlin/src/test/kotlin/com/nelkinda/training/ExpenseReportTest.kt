package com.nelkinda.training

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class ExpenseReportTest {


    @Test
    fun `it should return report for expenses within limit`() {
        val breakfastExpenseOne = addExpense(1000, ExpenseType.BREAKFAST)
        val breakfastExpenseTwo = addExpense(1000, ExpenseType.BREAKFAST)
        val dinnerExpense = addExpense(3000, ExpenseType.DINNER)
        val expectedReport = """Expenses ${Date()}
Breakfast	1000	 
Breakfast	1000	 
Dinner	3000	 
Meal expenses: 5000
Total expenses: 5000"""

        val expenses: List<Expense> = listOf(breakfastExpenseOne, breakfastExpenseTwo, dinnerExpense)
        val expenseReport = ExpenseReport()

        val actualReport = expenseReport.generateReport(expenses)

        assertEquals(expectedReport, actualReport)
    }

    private fun addExpense(amount: Int, expenseType: ExpenseType): Expense {
        val expense = Expense()
        expense.amount = amount
        expense.type = expenseType
        return expense
    }

    @Test
    fun `it should return dinner expenses and breakfast expenses total as meal expenses`() {
        val breakfast = addExpense(1500, ExpenseType.BREAKFAST)
        val dinner = addExpense(2000, ExpenseType.DINNER)

        val mealExpense = ExpenseReport().calculateMealExpense(listOf(breakfast, dinner))

        assertEquals(3500, mealExpense)
    }

    @Test
    fun `it should return report for expenses outside limit`() {
        val breakfastExpenseOne = addExpense(2000, ExpenseType.BREAKFAST)
        val dinnerExpense = addExpense(6000, ExpenseType.DINNER)
        val expectedReport = """Expenses ${Date()}
Breakfast	2000	X
Dinner	6000	X
Meal expenses: 8000
Total expenses: 8000"""

        val expenses: List<Expense> = listOf(breakfastExpenseOne, dinnerExpense)
        val expenseReport = ExpenseReport()

        val actualReport = expenseReport.generateReport(expenses)

        assertEquals(expectedReport, actualReport)
    }

    @Test
    fun `it should mark expense if limit exceeds`() {
        val expense = addExpense(3000, ExpenseType.BREAKFAST)
        val expectedMarker = "X"

        val actualMarker = ExpenseReport().markExpense(expense)

        assertEquals(expectedMarker, actualMarker)
    }
}