package commands

import StaticFields.collection
import StaticFields.console
import StaticFields.tcomp
/**
 * Класс, реализующий команду print_ascending, которая выводит элементы коллекции по возрастанию
 */
class PrintAscending: AbstractCommand() {
    override var cmd = "print_ascending"
    override var info = "вывести элементы коллекции в порядке возрастания"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        var col = collection.toSortedSet(tcomp)
        col.forEach(){
            println(it.toString())
        }
    }

}