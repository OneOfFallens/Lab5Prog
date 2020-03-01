package commands
import StaticFields.collection
import StaticFields.console
import StaticFields.userfilename
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import java.io.BufferedOutputStream
import java.io.FileOutputStream

/**
 * Класс, реализующий команду save, которая сохраняет коллекцию в файл
 */
class SaveJackson: AbstractCommand(){
    override var cmd = "save"
    override var info = "сохранить коллекцию в файл"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(){
        var fileout = FileOutputStream(userfilename)
        var writer = BufferedOutputStream(fileout)
        var mapper: ObjectMapper = ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        var json: String = mapper.writeValueAsString(collection);
        var output = json.toByteArray()
        writer.write(output)
        writer.close()
    }
}