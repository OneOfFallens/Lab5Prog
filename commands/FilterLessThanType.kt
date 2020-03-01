package commands

import StaticFields.arr
import StaticFields.collection
import StaticFields.console
import TicketType
/**
 * Класс, реализующий команду filter_less_than_type, отображающие элементы, у которых значение типа меньше, чем заданное
 */
class FilterLessThanType : AbstractCommand() {
    override var cmd = "filter_less_than_type"
    override var info = "вывести элементы, значение поля type которых, меньше чем заданное "
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        var type: TicketType?
        if (arr.size == 2) {
            var searchValue: Int = -2
            when (arr[1]) {
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
            collection.forEach {
                if (it.type!!.value < searchValue) {
                    println(it.toString())
                    wasFound = true
                } else {
                    if (it.equals(collection.last()) and (!wasFound)) {
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