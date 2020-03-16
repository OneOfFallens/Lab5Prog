import com.fasterxml.jackson.databind.ObjectMapper
import commands.Clear
import commands.CommandManager
import commands.TicketComparator
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.time.LocalDateTime
import java.util.*

/**
 * Класс, реализующий действия консоли
 */
class Console {
    var consoleWorks: Boolean = true
    var stor = Storage("collection.json", 1L, false, Scanner(System.`in`), hashSetOf(), TicketComparator(), hashSetOf(), listOf())
    val e = InputException("Введенная вами строка не является командой, введите help чтобы получить список всех команд")
    var line: String? = null
    constructor(stor: Storage){
        this.stor = stor
    }
    var commands = stor.pcommands
    /**
     * Метод, реализующий считывание строки и определение, является ли строка командой, а также исполнение этой команды.
     */
    fun read() {
        while(consoleWorks){
            var noCommand = true
            while (noCommand){
                if(!stor.pscriptWorks) {
                    print("Введите команду: ")
                }
            line = stor.pscan.nextLine()
                stor.setArr(line!!.trim().split("\\s+".toRegex()))
                if (stor.parr[0] == "execute_script"){
                    if (stor.pscriptWorks){
                        println("В скрипте нельзя использовать команду execute_script во избежание рекурсии")
                        stor.pscriptWorks = false
                        consoleWorks = false
                        stor.pscan = Scanner(System.`in`)
                        consoleWorks = true
                        this.read()
                    }}
                stor.pcommands.forEach(){
            if (stor.parr[0] == it.cmd){
                it.execute(this)
                noCommand = false
            }
            else {
                try{
                if (it == stor.pcommands.last()) {
                    if (noCommand){
                    throw e }
                }}
                catch(e: InputException){
                    println(e)
                    if (stor.pscriptWorks){
                        println("чтение файла остановлено, получена инвалидная строка")
                        stor.pscriptWorks = false
                        consoleWorks = false
                        stor.pscan = Scanner(System.`in`)
                    }
                }
            }
        }

                }

    if (stor.parr[0] == "exit"){
        consoleWorks = false
    }
        }}


    /**
     * Метод, осуществлящий работу с входящим файлом
     */
    fun checkfile(){
        var mapper = ObjectMapper()
        try {
            val fileInput = FileInputStream(File(stor.puserfilename))
            val reader = BufferedInputStream(fileInput)
            val list: Array<Ticket>? = (mapper.readValue(reader, Array<Ticket>::class.java) ?: throw UserFileException())
            reader.close()
            fileInput.close()
            var array = listOf(Long)
            stor.setCollection(list!!.toHashSet())
            var max: Long = 0
            stor.pcollection.forEach(){ ticket ->
                var tick = ticket
                if (ticket.price <= 0.0){
                    println("В коллекции найден элемент с инвалидными значениями, работаем с пустой коллекцией")
                    stor.setCollection(hashSetOf())
                }
                if (ticket.person.location!!.x <= 0){
                    println("В коллекции найден элемент с инвалидными значениями, работаем с пустой коллекцией")
                    stor.setCollection(hashSetOf())
                }
                if (ticket.name == ""){
                    println("В коллекции найден элемент с инвалидными значениями, работаем с пустой коллекцией")
                    stor.setCollection(hashSetOf())
                }
                if (ticket.coordinates.y <= 103.0){
                    println("В коллекции найден элемент с инвалидными значениями, работаем с пустой коллекцией")
                    stor.setCollection(hashSetOf())
                }
                if (ticket.person.location!!.name.length > 852){
                    println("В коллекции найден элемент с инвалидными значениями, работаем с пустой коллекцией")
                    stor.setCollection(hashSetOf())
                }
                if (tick.id > max){
                    max = tick.id
                }
                var counter = 0
                stor.pcollection.forEach(){
                    if (tick.id == it.id){
                        counter += 1
                    }
                }
               if (counter > 1){
                    val clear = Clear(stor)
                   clear.execute(this)
                   stor.setBufId(1L)
                    println("В коллекции были найдены элементы с одинаковым id, считывание не удалось")
                }
                var datetime = LocalDateTime.parse(ticket.creationDate)
                if (datetime > LocalDateTime.now()){
                    stor.setCollection(hashSetOf())
                    println("В коллекции найден элемент, созданный в будущем, считывание не удалось")
                }
                stor.setBufId(max + 1)

            }
        }
        catch(e: UserFileException){
            println("файл пуст, создается пустая коллекция")
        }
        catch(e: Exception){
           println("проблемы с входным файлом, работаем с пустой коллекцией")
            stor.setCollection(hashSetOf())
            }

    }
}