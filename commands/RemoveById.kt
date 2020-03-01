package commands

import StaticFields.arr
import StaticFields.collection
import StaticFields.console
/**
 * Класс, реализующий команду remove_by_id, удаляющую элемент из коллекции по его id
 */
class RemoveById : AbstractCommand() {
    override var cmd = "remove_by_id"
    override var info = "удалить элемент коллекции по его id"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        if (arr.size == 2) {
            var searchId: Long = arr[1].toLong()
            collection.forEach {
                if (it.id == searchId) {
                    collection.remove(it)
                } else {
                    if (it.equals(collection.last())) {
                        println("Элемент с таким id не найден ")
                    }
                }
            }
        }
        else{
            throw Exception("Неправильный формат команды")
        }
    }

}