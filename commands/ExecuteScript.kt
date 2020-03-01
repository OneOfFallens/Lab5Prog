package commands

import StaticFields.arr
import StaticFields.console
import StaticFields.scan
import StaticFields.scriptWorks
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.util.*
import kotlin.NoSuchElementException

/**
 * Класс, реализующий команду execute_script, которая исполняет скрипт, записанный в файле, указанном пользователем
 */
class ExecuteScript: AbstractCommand() {
    override var cmd = "execute_script"
    override var info = "cчитать и исполнить скрипт из указанного файла"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        var filename = arr[1]

        try {
            var file = FileInputStream(filename)
            scan = Scanner(file)
            scriptWorks = true
        }
        catch(e: FileNotFoundException){
            println("Файл не найден, исполнение скрипта невозможно")
        }
        while(scriptWorks){
            try {
                console.read()
            }
            catch(e:NoSuchElementException){
                println("файл закончен")
                scan = Scanner(System.`in`)
                scriptWorks = false
                console.consoleWorks = true
                break
            }
        }
    }
}