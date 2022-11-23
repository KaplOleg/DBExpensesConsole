package practiceFive.Interfaces

import practiceFive.Classes.DataBase.Expense

interface ISearch {
    fun search(strSearch: String?, list: MutableList<Expense>): MutableList<Expense>
}