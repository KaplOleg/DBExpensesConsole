package practiceFive.Interfaces.CRUD

import practiceFive.Classes.DataBase.Expense

interface IReadExpense {
    fun read(list: MutableList<Expense>)
}