package commands

import Console


/**
 * Класс, реализующий команду exit, завершающую работу консоли без сохранения
 */
class Exit: AbstractCommand() {
    override var cmd = "exit"
    override var info = "завершает работу программы без сохранения"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        println("Работа завершена без сохранения! ")
    }

}