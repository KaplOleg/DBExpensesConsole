package practiceFive.Classes.CRUD

import practiceFive.Classes.DataBase.Expense
import practiceFive.Classes.Messages
import practiceFive.Interfaces.CRUD.IUpdateExpense
import practiceFive.Interfaces.IO.IInput
import practiceFive.Interfaces.IO.IOutput

class UpdateExpenseList (private val input: IInput,
                         private val print: IOutput): IUpdateExpense {
    override fun update(id: Int?, list: MutableList<Expense>) {
        if(id == null) {
            print.print(Messages.FAILED.str)
        } else {
            val product = list.getOrNull(id - 1)
            if(product == null){
                print.print(Messages.FAILED.str)
            } else {
                print.print(Messages.REQUEST_NAME.str)
                val productNameUpdate = input.input()
                if(productNameUpdate.isNullOrEmpty()) product.productName else product.productName = productNameUpdate
                print.print(Messages.REQUEST_PRICE.str)
                product.productPrice = input.input()?.toDoubleOrNull() ?: product.productPrice
                print.print(Messages.REQUEST_COUNT.str)
                product.productCount = input.input()?.toIntOrNull() ?: product.productCount

                list[id - 1] = product
                print.print(Messages.SUCCESS.str)
            }
        }
    }
}