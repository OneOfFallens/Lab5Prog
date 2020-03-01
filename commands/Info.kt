package commands

import StaticFields.collection
import StaticFields.console
/**
 * Класс, реализующий команду info, выводящая информацию о коллекции, с которой работает юзер.
 */
class Info: AbstractCommand() {
    override var cmd = "info"
    override var info = "вывести в стандартный поток вывода информацию о коллекции"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        println(
            "Тип коллекции: ${collection::class.java.name} \n" +
                    "Количество элементов в коллекции: ${collection.size}"
        )
    }

}