package commands

import Console
import Storage


/**
 * Класс, реализующий команду clear, очищающую коллекцию
 */
class Clear(gstor: Storage): AbstractCommand() {
    override var cmd = "clear"
    var stor = gstor
    override var info = "очищает коллекцию"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console) {
        console.stor.pcollection.clear()
    }

}