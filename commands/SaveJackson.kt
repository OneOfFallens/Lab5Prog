package commands
import Console
import Storage
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import java.io.BufferedOutputStream
import java.io.FileOutputStream

/**
 * Класс, реализующий команду save, которая сохраняет коллекцию в файл
 */
class SaveJackson (gstor: Storage): AbstractCommand(){
    override var cmd = "save"
    var stor = gstor
    override var info = "сохранить коллекцию в файл"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console){
        var fileout = FileOutputStream(console.stor.puserfilename)
        var writer = BufferedOutputStream(fileout)
        var mapper: ObjectMapper = ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        var json: String = mapper.writeValueAsString(console.stor.pcollection);
        var output = json.toByteArray()
        writer.write(output)
        writer.close()
    }
}