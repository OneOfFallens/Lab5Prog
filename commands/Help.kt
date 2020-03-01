package commands

import StaticFields.console
import StaticFields.manager
/**
 * Класс, реализующий команду help, которая выводи справку по доступным командам
 */
class Help: AbstractCommand() {
    override var cmd = "help"
    override var info = "вывести справку по доступным командам"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        manager.commands.forEach{
            println("${it.cmd} - ${it.info}")
        }
    }
}