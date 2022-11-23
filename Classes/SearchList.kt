package practiceFive.Classes

import practiceFive.Classes.DataBase.Expense
import practiceFive.Interfaces.IO.IOutput
import practiceFive.Interfaces.ISearch

class SearchList (private val print: IOutput): ISearch {
    override fun search(strSearch: String?, list: MutableList<Expense>): MutableList<Expense> {
        print.print(Messages.LIST_SEARCH.str)
        return  list.filter { it.productName.equals(strSearch) }.toMutableList()
    }
}