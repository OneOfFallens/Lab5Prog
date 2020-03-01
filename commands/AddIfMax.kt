package commands

import StaticFields.collection
import StaticFields.tcomp
import InputException
import Ticket

/**
 * Класс, реализующий команду add_if_max, добавляющую элемент в коллекцию, если его цена будет максимальной
 */
class AddIfMax: AbstractCommand() {
    override var cmd = "add_if_max"
    override var info = "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        var max = collection.maxBy { it.price } ?: throw InputException("C коллекцией что-то не так")
        var add = Add()
        add.execute()
        var last = collection.maxBy { it.id } ?: throw InputException("С коллекцией что-то не так")
        println("${max.price}, ${last.price}")
        println(last.compareTo(max))
        if ((tcomp.compare(last, max))<= 0){
            collection.remove(collection.maxBy { it.id }!!)
            println("Элемент не был включен в коллекцию, так как его цена не максимальна")
        }
    }
}