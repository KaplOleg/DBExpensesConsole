package practiceFive.Classes.DataBase

import practiceFive.Classes.Messages
import practiceFive.Interfaces.IDataBaseList
import practiceFive.Interfaces.IO.IInput
import practiceFive.Interfaces.IO.IOutput

enum class Operations{
    update, delete
}

class DataBaseList (private val input: IInput,
                    private val print: IOutput): IDataBaseList {

    private var _list: MutableList<Expense> = mutableListOf()

    override var data: MutableList<Expense>
        get() = _list
        set(value) {_list = value}

    override fun create(e: Expense) {
        if (_list.add(e)) print.print(Messages.SUCCESS.str) else print.print(Messages.FAILED.str)
    }

    override fun update(id: Int?) {
        operationWithNullCheck(Operations.update.name, id)
    }

    override fun delete(id: Int?) {
        operationWithNullCheck(Operations.delete.name, id)
    }

    override fun read(list: MutableList<Expense>) {
        if(list.isEmpty()) print.print(Messages.LIST_EMPTY.str) else list.forEach { print.print(it.toString()) }
    }

    override fun sort() {
        _list.sortBy { it.productName }
        print.print(Messages.LIST_SORT.str)
        read(_list)
    }

    override fun search(strSearch: String?) {
        var listSearch = _list.filter { it.productName.equals(strSearch) }.toMutableList()
        print.print(Messages.LIST_SEARCH.str)
        read(listSearch)
    }

    private fun operationWithNullCheck(operation: String, id: Int?){
        if(id == null) {
            print.print(Messages.FAILED.str)
        } else {
            val product = _list.getOrNull(id - 1)
            if(product == null){
                print.print(Messages.FAILED.str)
            } else {
                when(operation) {
                    Operations.delete.name -> {
                        if(_list.remove(product)) print.print(Messages.SUCCESS.str) else print.print(Messages.FAILED.str)
                    }
                    Operations.update.name -> {
                        print.print(Messages.REQUEST_NAME.str)
                        val productNameUpdate = input.input()
                        if(productNameUpdate.isNullOrEmpty()) product.productName else product.productName = productNameUpdate
                        print.print(Messages.REQUEST_PRICE.str)
                        product.productPrice = input.input()?.toDoubleOrNull() ?: product.productPrice
                        print.print(Messages.REQUEST_COUNT.str)
                        product.productCount = input.input()?.toIntOrNull() ?: product.productCount

                        _list[id - 1] = product
                        print.print(Messages.SUCCESS.str)
                    }
                }
            }
        }
    }
}