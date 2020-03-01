import StaticFields.collection
import StaticFields.userfilename
import commands.Exit
import java.io.BufferedOutputStream
import java.io.FileNotFoundException
import java.lang.IndexOutOfBoundsException
import javax.management.Query.or

fun main(args: Array<String>?){
    userfilename = try{
        when (val input = args?.get(0)){
            "" -> "collection.json"
            null -> "collection.json"
            else -> input
        }
    }
    catch(e: IndexOutOfBoundsException){
        println("Не было подано входных аргументов")
        "collection.json"
    }
    if (args!!.size>1){
        println("Было подано более одного входного элемента")
        userfilename = "collection.json"
    }
    println("Работаем с файлом $userfilename")
    println("starting application")
    val console: Console = Console()
    try {
        console.checkfile()
    }
    catch(e: FileNotFoundException){
        println("Файл не существует или прав на него недостаточно")
        collection = hashSetOf()
    }
    catch(e: Exception){
        println("Что-то пошло не так, создается пустая коллекция")
        collection = hashSetOf()
    }
    console.read()
}