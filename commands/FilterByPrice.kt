package commands

import StaticFields.arr
import StaticFields.collection
import StaticFields.console
import InputException
/**
 * Класс, реализующий команду filter_by_price, которая выводит элементы, у которых цена равна заданной юзером
 */
class FilterByPrice : AbstractCommand() {
    override var cmd = "filter_by_price"
    override var info = "вывести элементы, значения поля  price которых равно заданному"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        if (arr.size == 2) {
            var wasFound: Boolean = false
            var searchPrice: Long = arr[1].toLong()
            collection.forEach {
                if (it.id == searchPrice) {
                    println(it.toString())
                    wasFound = true
                } else {
                    if (it.equals(collection.last()) and (!wasFound)) {
                        println("Билеты с такой ценой не найдены ")
                    }
                }
            }
        }
        else{
            throw InputException("Неправильный формат команды")
        }
    }

}