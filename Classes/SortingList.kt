package practiceFive.Classes

import practiceFive.Classes.DataBase.Expense
import practiceFive.Interfaces.IO.IOutput
import practiceFive.Interfaces.ISort

class SortingList (private val print: IOutput): ISort {
    override fun sort(list: MutableList<Expense>) {
        print.print(Messages.LIST_SORT.str)
        list.sortBy { it.productName }
    }
}