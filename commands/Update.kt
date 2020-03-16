package commands

import Console
import Storage
import java.lang.NumberFormatException

/**
 * Класс, реализующий команду update, которая заменят объект коллекции с заданным id
 */
class Update(gstor: Storage): AbstractCommand() {
    override var cmd = "update"
    var stor = gstor
    override var info = "обновить значение элемента коллекции, id которого равен заданному"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        if (console.stor.parr.size == 2) {
            try {
                var searchId: Long = console.stor.parr[1].toLong()
                console.stor.pcollection.forEach {
                    if (it.id == searchId) {
                        val buf: Long =  console.stor.pbuf_id + 1
                        console.stor.setBufId(it.id)
                        val add = Add(console.stor)
                        add.execute(console)
                        console.stor.pbuf_id = buf
                        console.stor.pcollection.remove(it)
                    } else {
                        if (it.equals(console.stor.pcollection.last())) {
                            println("Элемент с таким id не найден ")
                        }
                    }
                }
            }
            catch(e: NumberFormatException){
                println("Некорректный формат команды update")
            }

        }
        else{
            throw Exception("Неправильный формат команды")
        }
    }

}