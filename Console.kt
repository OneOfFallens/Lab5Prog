import StaticFields.arr
import StaticFields.buf_id
import StaticFields.collection
import StaticFields.console
import StaticFields.manager
import StaticFields.scan
import StaticFields.scriptWorks
import StaticFields.userfilename
import com.fasterxml.jackson.databind.ObjectMapper
import commands.Exit
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.time.LocalDateTime
import java.util.*

/**
 * Класс, реализующий действия консоли
 */
class Console {
    var consoleWorks = true
    var noCommand = true
    val e = InputException("Введенная вами строка не является командой, введите help чтобы получить список всех команд")
    var line: String? = null
    /**
     * Метод, реализующий считывание строки и определение, является ли строка командой, а также исполнение этой команды.
     */
    fun read() {
        while(consoleWorks){
            noCommand = true
            while (noCommand){
                if(!scriptWorks) {
                    print("Введите команду: ")
                }
            line = scan.nextLine()
        arr = line!!.split(" ")
                if (arr[0] == "execute_script"){
                    if (scriptWorks){
                        println("В скрипте нельзя использовать команду execute_script во избежание рекурсии")
                        scriptWorks = false
                        consoleWorks = false
                        scan = Scanner(System.`in`)
                        consoleWorks = true
                        console.read()

                    }
        manager.commands.forEach(){
            if (arr[0].equals(it.cmd)){
                it.execute()
                noCommand = false
            }
            else {
                try{
                if (it.equals(manager.commands.last())) {
                    if (noCommand){
                    throw e }
                }}
                catch(e: InputException){
                    println(e)
                    if (scriptWorks){
                        println("чтение файла остановлено, получена инвалидная строка")
                        scriptWorks = false
                        consoleWorks = false
                        scan = Scanner(System.`in`)
                    }
                }
            }
        }

                }

    if (arr[0] == "exit"){
        consoleWorks = false
    }
        }}
    }

    /**
     * Метод, осуществлящий работу с входящим файлом
     */
    fun checkfile(){
        var mapper = ObjectMapper()
        try {
            val fileInput = FileInputStream(File(userfilename))
            val reader = BufferedInputStream(fileInput)
            val list: Array<Ticket>? = (mapper.readValue(reader, Array<Ticket>::class.java) ?: throw UserFileException())
            reader.close()
            fileInput.close()
            var array = listOf(Long)
            collection = list!!.toHashSet()
            var max: Long = 0
            collection.forEach(){ ticket ->
                var tick = ticket
                if (tick.id>max){
                    max = tick.id
                }
                var counter = 0
                collection.forEach(){
                    if (tick.id == it.id){
                        counter += 1
                    }
                }
                if (counter > 1){
                    collection = hashSetOf()
                    buf_id = 1
                    println("В коллекции были найдены элементы с одинаковым id, считывание не удалось")
                }
                var datetime = LocalDateTime.parse(ticket.creationDate)
                if (datetime> LocalDateTime.now()){
                    collection = hashSetOf()
                    println("В коллекции найден элемент, созданный в будущем, считывание не удалось")
                }
                buf_id = max + 1

            }
        }
        catch(e: UserFileException){
            println("файл пуст, создается пустая коллекция")
        }
        catch(e: Exception){
           println("проблемы с входным файлом, работаем с пустой коллекцией")
            collection = hashSetOf()
            }

    }
}