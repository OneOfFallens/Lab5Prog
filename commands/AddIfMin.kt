package commands

import Console
import InputException
import Storage
import Ticket
/**
 * Класс, реализующий команду add_if_min, добавляющую элемент в коллекцию, если его цена будет минимальной
 */
class AddIfMin(gstor: Storage): AbstractCommand() {
    override var cmd = "add_if_min"
    var stor = gstor
    override var info = "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        var min = console.stor.pcollection.minBy { it.price } ?: throw InputException("C коллекцией что-то не так")
        var add = Add(stor)
        add.execute(console)
        var last = console.stor.pcollection.maxBy { it.id } ?: throw InputException("С коллекцией что-то не так")
        println("$min, $last")
        println(last.compareTo(min))
        if ((console.stor.ptcomp.compare(min, last)) <= 0){
            console.stor.pcollection.remove(console.stor.pcollection.maxBy { it.id }!!)
            println("Элемент не был включен в коллекцию, так как его цена не минимальна")
        }
    }
}