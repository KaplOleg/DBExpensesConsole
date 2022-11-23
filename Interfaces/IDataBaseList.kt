package practiceFive.Interfaces

import practiceFive.Classes.DataBase.Expense
import practiceFive.Interfaces.CRUD.ICreateExpense
import practiceFive.Interfaces.CRUD.IReadExpense
import practiceFive.Interfaces.CRUD.IUpdateExpense
import practiceFive.Interfaces.CRUD.IDeleteExpense

interface IDataBaseList: ICreateExpense,IReadExpense, IUpdateExpense, IDeleteExpense, ISort, ISearch {
    override fun create(e: Expense)
    override fun read(list: MutableList<Expense>)
    override fun update(id: Int?)
    override fun delete(id: Int?)

    override fun sort()
    override fun search(strSearch: String?)

    var data: MutableList<Expense>
}