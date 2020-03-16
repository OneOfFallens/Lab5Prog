package commands

import Console
import Storage

/**
 * Класс, реализующий команду info, выводящая информацию о коллекции, с которой работает юзер.
 */
class Info(gstor: Console): AbstractCommand() {
    override var cmd = "info"
    override var info = "вывести в стандартный поток вывода информацию о коллекции"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        println(
            "Тип коллекции: ${console.stor.pcollection::class.java.name} \n" +
                    "Количество элементов в коллекции: ${console.stor.pcollection.size}"
        )
    }

}