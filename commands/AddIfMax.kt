package commands

import Console
import InputException
import Storage
import Ticket

/**
 * Класс, реализующий команду add_if_max, добавляющую элемент в коллекцию, если его цена будет максимальной
 */
class AddIfMax(gstor: Storage): AbstractCommand() {
    override var cmd = "add_if_max"
    override var info = "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции"
    var stor = gstor
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        var max = console.stor.pcollection.maxBy { it.price } ?: throw InputException("C коллекцией что-то не так")
        var add = Add(stor)
        add.execute(console)
        var last = console.stor.pcollection.maxBy { it.id } ?: throw InputException("С коллекцией что-то не так")
        println("${max.price}, ${last.price}")
        println(last.compareTo(max))
        if ((console.stor.ptcomp.compare(last, max))<= 0){
            console.stor.pcollection.remove(console.stor.pcollection.maxBy { it.id }!!)
            println("Элемент не был включен в коллекцию, так как его цена не максимальна")
        }
    }
}