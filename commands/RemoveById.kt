package commands

import Console
import Storage

/**
 * Класс, реализующий команду remove_by_id, удаляющую элемент из коллекции по его id
 */
class RemoveById(gstor: Storage) : AbstractCommand() {
    override var cmd = "remove_by_id"
    var stor = gstor
    override var info = "удалить элемент коллекции по его id"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        if (console.stor.parr.size == 2) {
            var searchId: Long = console.stor.parr[1].toLong()
            console.stor.pcollection.forEach {
                if (it.id == searchId) {
                    console.stor.pcollection.remove(it)
                } else {
                    if (it.equals(console.stor.pcollection.last())) {
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