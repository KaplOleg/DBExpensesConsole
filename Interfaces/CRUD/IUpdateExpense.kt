package practiceFive.Interfaces.CRUD

import practiceFive.Classes.DataBase.Expense

interface IUpdateExpense {
    fun update(id: Int?, list: MutableList<Expense>)
}