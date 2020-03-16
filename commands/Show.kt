package commands

import Console
import Storage


/**
 * Класс, реализующий команду show, которая выводит строковое представление всех элементов коллекции
 */
class Show(gstor: Storage): AbstractCommand() {
    override var cmd = "show"
    var stor = gstor
    override var info = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        console.stor.pcollection.forEach(){
            println(it.toString())
        }
    }
}