package practiceFive

import practiceFive.Classes.CRUD.CreateExpenseList
import practiceFive.Classes.CRUD.DeleteExpenseList
import practiceFive.Classes.CRUD.UpdateExpenseList
import practiceFive.Classes.DataBase.CreateNewExpense
import practiceFive.Classes.DataBase.DataBase
import practiceFive.Classes.DataBase.Expense
import practiceFive.Classes.IO.InputToDesktop
import practiceFive.Classes.IO.OutputToDesktop
import practiceFive.Classes.Messages
import practiceFive.Classes.SearchList
import practiceFive.Classes.SortingList

fun main(){
    val print = OutputToDesktop()
    val input = InputToDesktop()

    val dataBase = DataBase(mutableListOf(
        Expense("Молоко",39.0 ,3),
        Expense("Аленка", 109.0 ,1),
        Expense("Шоколадка",69.0, 2),
        Expense("Баклажан",10.0,2)
    ), print)

    fun displayAction() {
        print.print(Messages.START_MENU.str)
    }

    displayAction()
    do {
        val res = input.input()?.toIntOrNull() ?: 0
        when (res) {
            0 -> displayAction()
            1 -> dataBase.read(dataBase.data)
            2 -> dataBase.create(CreateNewExpense(input, print), CreateExpenseList(print))
            3 -> {
                print.print(Messages.REQUEST_ID.str)
                val expense_id = input.input()?.toIntOrNull()
                dataBase.update(expense_id, UpdateExpenseList(input, print))
            }
            4 -> {
                print.print(Messages.REQUEST_ID.str)
                val expense_id = input.input()?.toIntOrNull()
                dataBase.delete(expense_id, DeleteExpenseList(print))
            }
            5 -> dataBase.sort(SortingList(print))
            6 -> {
                print.print(Messages.REQUEST_NAME.str)
                val strSearch = input.input()
                dataBase.search(strSearch, SearchList(print))
            }
        }
    } while (res < 7)
}