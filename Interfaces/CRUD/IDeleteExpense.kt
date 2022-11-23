package practiceFive.Interfaces.CRUD

import practiceFive.Classes.DataBase.Expense

interface IDeleteExpense {
    fun delete(id: Int?, list: MutableList<Expense>)
}