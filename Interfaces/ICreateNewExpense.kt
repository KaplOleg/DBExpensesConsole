package practiceFive.Interfaces

import practiceFive.Classes.DataBase.Expense
import practiceFive.Interfaces.IO.IInput

interface ICreateNewExpense {
    fun create(): Expense
}