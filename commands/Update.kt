package commands

import StaticFields.collection
import StaticFields.console
import StaticFields.arr
/**
 * Класс, реализующий команду update, которая заменят объект коллекции с заданным id
 */
class Update: AbstractCommand() {
    override var cmd = "update"
    override var info = "обновить значение элемента коллекции, id которого равен заданному"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        if (arr.size == 2) {
            var searchId: Long = arr[1].toLong()
            collection.forEach {
                if (it.id == searchId) {
                    val buf: Long = StaticFields.buf_id + 1
                    StaticFields.buf_id = it.id
                    val add = Add()
                    add.execute()
                    StaticFields.buf_id = buf
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