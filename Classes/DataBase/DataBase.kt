package practiceFive.Classes.DataBase

import practiceFive.Interfaces.CRUD.ICreateExpense
import practiceFive.Interfaces.CRUD.IDeleteExpense
import practiceFive.Interfaces.CRUD.IUpdateExpense
import practiceFive.Interfaces.ICreateNewExpense
import practiceFive.Interfaces.IDataBaseLogic
import practiceFive.Interfaces.IO.IOutput
import practiceFive.Interfaces.ISearch
import practiceFive.Interfaces.ISort

enum class Operations{
    update, delete
}

class DataBase (override val data: MutableList<Expense>,
                private val print: IOutput) : IDataBaseLogic {

    private var _list: MutableList<Expense> = data
    override fun create(newExpense: ICreateNewExpense, impl: ICreateExpense){
        impl.create(newExpense.create(), _list)
    }
    override fun read(list: MutableList<Expense>) {
        list.forEach { print.print(it.toString()) }
    }
    override fun update(id: Int?, impl: IUpdateExpense) {
        impl.update(id, _list)
    }
    override fun delete(id: Int?, impl: IDeleteExpense) {
        impl.delete(id, _list)
    }
    override fun sort(impl: ISort) {
        impl.sort(_list)
        read(_list)
    }
    override fun search(string: String?, impl: ISearch) {
        read(impl.search(string, _list))
    }

}