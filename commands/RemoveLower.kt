package commands

import StaticFields.collection
import StaticFields.tcomp
import InputException
import Ticket
/**
 * Класс, реализующий команду remove_lower, которая удаляет все элементы, цена которых меньше, чем у заданного
 */
class RemoveLower: AbstractCommand() {
    override var cmd = "remove_lower"
    override var info = "убрать все элементы, значение которых меньше, чем у входящего"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        var add = Add()
        add.execute()
        var last = collection.maxBy { it.id } ?: throw InputException("С коллекцией что-то не так")
        collection.forEach(){
        if ((tcomp.compare(last, it)) > 0){
            collection.remove(it)
            println("Элементы ниже заданного были удалены из коллекции")
        }}
    }
}