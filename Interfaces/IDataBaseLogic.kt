package practiceFive.Interfaces

import practiceFive.Classes.DataBase.Expense
import practiceFive.Interfaces.CRUD.ICreateExpense
import practiceFive.Interfaces.CRUD.IDeleteExpense
import practiceFive.Interfaces.CRUD.IUpdateExpense
import practiceFive.Interfaces.IO.IOutput

interface IDataBaseLogic {
    fun create(newExpense: ICreateNewExpense, impl: ICreateExpense)
    fun read(list: MutableList<Expense>)
    fun update(id: Int?, impl: IUpdateExpense)
    fun delete(id: Int?, impl: IDeleteExpense)

    fun sort(impl: ISort)
    fun search(string: String?, impl: ISearch)

    val data: MutableList<Expense>
}