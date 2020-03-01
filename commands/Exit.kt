package commands

import StaticFields.collection
import StaticFields.console
/**
 * Класс, реализующий команду exit, завершающую работу консоли без сохранения
 */
class Exit: AbstractCommand() {
    override var cmd = "exit"
    override var info = "завершает работу программы без сохранения"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        println("Работа завершена без сохранения! ")
    }

}