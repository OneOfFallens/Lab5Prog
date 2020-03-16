package commands

import Console
import InputException
import Storage
import Ticket
/**
 * Класс, реализующий команду remove_lower, которая удаляет все элементы, цена которых меньше, чем у заданного
 */
class RemoveLower(gstor: Storage): AbstractCommand() {
    override var cmd = "remove_lower"
    var stor = gstor
    override var info = "убрать все элементы, значение которых меньше, чем у входящего"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        var add = Add(stor)
        add.execute(console)
        var last = console.stor.pcollection.maxBy { it.id } ?: throw InputException("С коллекцией что-то не так")
        console.stor.pcollection.forEach(){
        if ((console.stor.ptcomp.compare(last, it)) > 0){
            console.stor.pcollection.remove(it)
            println("Элементы ниже заданного были удалены из коллекции")
        }}
    }
}