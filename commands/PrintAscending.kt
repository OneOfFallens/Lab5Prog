package commands

import Console
import Storage

/**
 * Класс, реализующий команду print_ascending, которая выводит элементы коллекции по возрастанию
 */
class PrintAscending(gstor: Storage): AbstractCommand() {
    override var cmd = "print_ascending"
    var stor = gstor
    override var info = "вывести элементы коллекции в порядке возрастания"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        var col = console.stor.pcollection.toSortedSet(stor.ptcomp)
        col.forEach(){
            println(it.toString())
        }
    }

}