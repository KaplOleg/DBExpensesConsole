package practiceFive.Interfaces

import practiceFive.Classes.DataBase.Expense

interface ISort {
    fun sort(list: MutableList<Expense>)
}