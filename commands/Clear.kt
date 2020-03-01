package commands

import StaticFields.collection
import StaticFields.console

/**
 * Класс, реализующий команду clear, очищающую коллекцию
 */
class Clear: AbstractCommand() {
    override var cmd = "clear"
    override var info = "очищает коллекцию"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        collection.clear()
    }

}