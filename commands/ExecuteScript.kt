package commands


import Console
import Storage
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.util.*
import kotlin.NoSuchElementException

/**
 * Класс, реализующий команду execute_script, которая исполняет скрипт, записанный в файле, указанном пользователем
 */
class ExecuteScript(gconsole: Console): AbstractCommand() {
    override var cmd = "execute_script"
    override var info = "cчитать и исполнить скрипт из указанного файла"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        var filename = console.stor.parr[1]
        try {
            var file = FileInputStream(filename)
            console.stor.setScan(Scanner(file))
            console.stor.setScriptWorks(true)
        }
        catch(e: FileNotFoundException){
            println("Файл не найден, исполнение скрипта невозможно")
        }
        while(console.stor.pscriptWorks){
            try {
                console.read()
            }
            catch(e:NoSuchElementException){
                println("файл закончен")
                console.stor.setScan(Scanner(System.`in`))
                console.stor.setScriptWorks(false)
                console.consoleWorks = true
                break
            }
        }
    }
}