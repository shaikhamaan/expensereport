package com.nelkinda.training

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class ExpenseReportTest {


    @Test
    fun `it should return report for expenses within limit`() {
        val breakfastExpenseOne = Expense(1000, ExpenseType.BREAKFAST)
        val breakfastExpenseTwo = Expense(1000, ExpenseType.BREAKFAST)
        val dinnerExpense = Expense(3000, ExpenseType.DINNER)
        val expectedReport =
            "Expenses ${Date()}\n" +
                    "Breakfast\t1000\t \n" +
                    "Breakfast\t1000\t \n" +
                    "Dinner\t3000\t \n" +
                    "Meal expenses: 5000\n" +
                    "Total expenses: 5000"

        val expenses: List<Expense> = listOf(breakfastExpenseOne, breakfastExpenseTwo, dinnerExpense)
        val expenseReport = ExpenseReport()

        val actualReport = expenseReport.generateReport(expenses)

        assertEquals(expectedReport, actualReport)
    }


    @Test
    fun `it should return dinner expenses and breakfast expenses total as meal expenses`() {
        val breakfast = Expense(1500, ExpenseType.BREAKFAST)
        val dinner = Expense(2000, ExpenseType.DINNER)

        val mealExpense = ExpenseReport().calculateMealExpense(listOf(breakfast, dinner))

        assertEquals(3500, mealExpense)
    }

    @Test
    fun `it should return report for expenses outside limit`() {
        val breakfastExpenseOne = Expense(2000, ExpenseType.BREAKFAST)
        val dinnerExpense = Expense(6000, ExpenseType.DINNER)
        val expectedReport =
            "Expenses ${Date()}\n" +
                    "Breakfast\t2000\tX\n" +
                    "Dinner\t6000\tX\n" +
                    "Meal expenses: 8000\n" +
                    "Total expenses: 8000"

        val expenses: List<Expense> = listOf(breakfastExpenseOne, dinnerExpense)
        val expenseReport = ExpenseReport()

        val actualReport = expenseReport.generateReport(expenses)

        assertEquals(expectedReport, actualReport)
    }

    @Test
    fun `it should mark expense if limit exceeds`() {
        val expense = Expense(3000, ExpenseType.BREAKFAST)
        val expectedMarker = "X"

        val actualMarker = expense.limitStatus

        assertEquals(expectedMarker, actualMarker)
    }
}