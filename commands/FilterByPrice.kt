package commands

import Console
import InputException
import Storage

/**
 * Класс, реализующий команду filter_by_price, которая выводит элементы, у которых цена равна заданной юзером
 */
class FilterByPrice(gstor: Storage) : AbstractCommand() {
    override var cmd = "filter_by_price"
    var stor = gstor
    override var info = "вывести элементы, значения поля  price которых равно заданному"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        if (console.stor.parr.size == 2) {
            var wasFound: Boolean = false
            var searchPrice: Long = stor.parr[1].toLong()
            console.stor.pcollection.forEach {
                if (it.id == searchPrice) {
                    println(it.toString())
                    wasFound = true
                } else {
                    if (it.equals(console.stor.pcollection.last()) and (!wasFound)) {
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