import commands.CommandManager
import commands.SaveJackson
import commands.TicketComparator
import java.io.FileNotFoundException
import java.lang.IndexOutOfBoundsException
import java.time.format.DateTimeParseException
import java.util.*


fun main(args: Array<String>?){
    var stor = Storage("collection.json", 1L, false, Scanner(System.`in`), hashSetOf(), TicketComparator(), hashSetOf(), listOf())
    var console: Console = Console(stor)
    try{
        when (val input = args?.get(0)){
            "" -> stor.setFileName("collection.json")
            null -> stor.setFileName("collection.json")
            else -> stor.setFileName(input)
        }
    }
    catch(e: IndexOutOfBoundsException){
        println("Не было подано входных аргументов")
        stor.setFileName("collection.json")
    }
    if (args!!.size>1){
        println("Было подано более одного входного элемента")
        stor.setFileName("collection.json")
    }
    println("Работаем с файлом ${stor.puserfilename}")
    println("starting application")
    try {
        console.checkfile()
    }
    catch(e: FileNotFoundException){
        println("Файл не существует или прав на него недостаточно")
        stor.setCollection(hashSetOf())
    }
    catch(e: DateTimeParseException){
        println("Что-то не так с датой в файле, создана пустая коллекция")
        stor.setCollection(hashSetOf())
    }
    catch(e: Exception){
        println("Что-то пошло не так, создается пустая коллекция")
       stor.setCollection(hashSetOf())
    }
    var manager = CommandManager(console)
    var commands = manager.commands
    stor.setComm(commands)
    console = Console(stor)
    manager = CommandManager(console)
    commands = manager.commands
    console.read()
}