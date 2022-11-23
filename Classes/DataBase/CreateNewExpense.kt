package practiceFive.Classes.DataBase

import practiceFive.Interfaces.ICreateNewExpense
import practiceFive.Interfaces.IO.IInput
import practiceFive.Interfaces.IO.IOutput
import practiceFive.Classes.Messages

class CreateNewExpense (private val input: IInput,
                        private val print: IOutput): ICreateNewExpense {

    override fun create(): Expense {
        print.print(Messages.REQUEST_NAME.str)
        val productName = input.input()
        print.print(Messages.REQUEST_PRICE.str)
        val productPrice = input.input()?.toDoubleOrNull()
        print.print(Messages.REQUEST_COUNT.str)
        val productCount = input.input()?.toIntOrNull()

        return Expense(productName, productPrice, productCount)
    }
}