package practiceFive.Classes.CRUD

import practiceFive.Interfaces.CRUD.IDeleteExpense
import practiceFive.Interfaces.IO.IOutput
import practiceFive.Classes.DataBase.Expense
import practiceFive.Classes.Messages

class DeleteExpenseList (private val print: IOutput): IDeleteExpense {

    override fun delete(id: Int?, list: MutableList<Expense>) {
        if(id == null) {
            print.print(Messages.FAILED.str)
        } else {
            val product = list.getOrNull(id - 1)
            if (product == null) {
                print.print(Messages.FAILED.str)
            } else {
                if (list.remove(product)) print.print(Messages.SUCCESS.str) else print.print(Messages.FAILED.str)
            }
        }
    }
}