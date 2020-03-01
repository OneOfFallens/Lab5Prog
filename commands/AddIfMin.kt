package commands

import StaticFields.collection
import StaticFields.tcomp
import InputException
import Ticket
/**
 * Класс, реализующий команду add_if_min, добавляющую элемент в коллекцию, если его цена будет минимальной
 */
class AddIfMin: AbstractCommand() {
    override var cmd = "add_if_min"
    override var info = "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        var min = collection.minBy { it.price } ?: throw InputException("C коллекцией что-то не так")
        var add = Add()
        add.execute()
        var last = collection.maxBy { it.id } ?: throw InputException("С коллекцией что-то не так")
        println("$min, $last")
        println(last.compareTo(min))
        if ((tcomp.compare(min, last)) <= 0){
            collection.remove(collection.maxBy { it.id }!!)
            println("Элемент не был включен в коллекцию, так как его цена не минимальна")
        }
    }
}