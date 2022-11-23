package practiceFive.Classes.DataBase

import javax.xml.crypto.Data

data class Expense (var productName: String?, var productPrice: Double?, var productCount: Int?){
    override fun toString(): String {
        return  "Продукт: $productName Цена: $productPrice Кол-во: $productCount"
    }
}

