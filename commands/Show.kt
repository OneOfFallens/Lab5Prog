package commands

import StaticFields.collection
import StaticFields.console
/**
 * Класс, реализующий команду show, которая выводит строковое представление всех элементов коллекции
 */
class Show: AbstractCommand() {
    override var cmd = "show"
    override var info = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        collection.forEach(){
            println(it.toString())
        }
        console.read()
    }
}