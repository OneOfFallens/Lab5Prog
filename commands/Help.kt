package commands

import Console
import Storage

/**
 * Класс, реализующий команду help, которая выводи справку по доступным командам
 */
class Help(gstor: Storage, gmanager: CommandManager): AbstractCommand() {
    override var cmd = "help"
    var manager = gmanager
    var stor = gstor
    override var info = "вывести справку по доступным командам"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        manager.commands.forEach{
            println("${it.cmd} - ${it.info}")
        }
    }
}