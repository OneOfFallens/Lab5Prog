package commands

import Console
import Storage
import TicketType
/**
 * Класс, реализующий команду filter_less_than_type, отображающие элементы, у которых значение типа меньше, чем заданное
 */
class FilterLessThanType(gstor: Storage) : AbstractCommand() {
    override var cmd = "filter_less_than_type"
    var stor = gstor
    override var info = "вывести элементы, значение поля type которых, меньше чем заданное "
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        var type: TicketType?
        if (console.stor.parr.size == 2) {
            var searchValue: Int = -2
            when (console.stor.parr[1]) {
                "VIP" -> type = TicketType.VIP
                "USUAL" -> type = TicketType.USUAL
                "BUDGETARY" -> type = TicketType.BUDGETARY
                "CHEAP" -> type = TicketType.CHEAP
                null -> {searchValue = -1
                    type = null}
                else -> throw Exception("Это не тип билета")
            }
            var wasFound: Boolean = false
            if (type !=null){
                searchValue = type.value}
            console.stor.pcollection.forEach {
                if (it.type!!.value < searchValue) {
                    println(it.toString())
                    wasFound = true
                } else {
                    if (it.equals(console.stor.pcollection.last()) and (!wasFound)) {
                        println("Билеты с ниже этого типа не найдены ")
                    }
                }
            }
        }
        else{
            throw Exception("Неправильный формат команды")
        }
    }

}