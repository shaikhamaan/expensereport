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

        val actualReport = expenseReport.printReport(expenses)
        println("actual report")
        println(actualReport)
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
}