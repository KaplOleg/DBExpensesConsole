package practiceFive

import practiceFive.Classes.DataBase.CreateNewExpense
import practiceFive.Classes.DataBase.DataBaseList
import practiceFive.Classes.DataBase.Expense
import practiceFive.Classes.IO.InputToDesktop
import practiceFive.Classes.IO.OutputToDesktop
import practiceFive.Classes.Messages

fun main(){
    val print = OutputToDesktop()
    val input = InputToDesktop()

    val dataBase = DataBaseList(input, print)
    val createNewExpense = CreateNewExpense(input, print)

    dataBase.data = mutableListOf(
        Expense("Молоко",39.0 ,3),
        Expense("Аленка", 109.0 ,1),
        Expense("Шоколадка",69.0, 2),
        Expense("Баклажан",10.0,2)
    )

    fun displayAction() {
        print.print(Messages.START_MENU.str)
    }

    displayAction()
    do {
        val res = input.input()?.toIntOrNull() ?: 0
        when (res) {
            0 -> displayAction()
            1 -> dataBase.read(dataBase.data)
            2 -> dataBase.create(createNewExpense.create())
            3 -> {
                print.print(Messages.REQUEST_ID.str)
                val expense_id = input.input()?.toIntOrNull()
                dataBase.update(expense_id)
            }
            4 -> {
                print.print(Messages.REQUEST_ID.str)
                val expense_id = input.input()?.toIntOrNull()
                dataBase.delete(expense_id)
            }
            5 -> dataBase.sort()
            6 -> {
                print.print(Messages.REQUEST_NAME.str)
                val strSearch = input.input()
                dataBase.search(strSearch)
            }
        }
    } while (res < 7)
}