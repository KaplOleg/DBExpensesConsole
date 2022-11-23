package practiceFive.Interfaces.CRUD

import practiceFive.Classes.DataBase.Expense

interface ICreateExpense {
    fun create(e: Expense, list: MutableList<Expense>)
}