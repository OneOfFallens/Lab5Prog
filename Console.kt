import StaticFields.arr
import StaticFields.collection
import StaticFields.console
import StaticFields.filein

import StaticFields.manager
import StaticFields.scan
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.*
import com.fasterxml.jackson.databind.util.StdDateFormat
import com.fasterxml.jackson.databind.SerializationFeature
import java.lang.Compiler.disable


class Console {
    var consoleWorks = true
    var noCommand = true
    val e = InputException("Введенная вами строка не является командой")
    var line: String? = null
    fun read() {
        while(consoleWorks){
            noCommand = true
            while (noCommand){
        print("Введите команду: ")
            line = scan.nextLine()
        arr = line!!.split(" ")
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
                }
            }
        }
    if (arr[0] == "exit"){
        consoleWorks = false
    }
        }}
    }

    fun checkfile(){
        val mapper = ObjectMapper()
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        try {
            var list: HashSet<Ticket> = mapper.readValue(FileReader("collection.txt"))
        }
        catch(e: Exception){
            print(e)
        }
    }
}




