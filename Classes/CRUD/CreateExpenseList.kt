package practiceFive.Classes.CRUD

import practiceFive.Interfaces.CRUD.ICreateExpense
import practiceFive.Interfaces.IO.IOutput
import practiceFive.Classes.DataBase.Expense
import practiceFive.Classes.Messages

class CreateExpenseList (private val print: IOutput): ICreateExpense {
    override fun create(e: Expense, list: MutableList<Expense>) {
        if (list.add(e)) print.print(Messages.SUCCESS.str) else print.print(Messages.FAILED.str)
    }
}