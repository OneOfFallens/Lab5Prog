import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import commands.CommandManager
import commands.TicketComparator
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*
import kotlin.collections.HashSet

object StaticFields {
    var buf_id: Long = 1
    var tcomp = TicketComparator()
    var userfilename: String? = "collection.txt"
    // var filein: FileInputStream = FileInputStream("collection.txt")
    var console: Console = Console()
    var arr = listOf<String>()
    val manager: CommandManager = CommandManager()
    @JsonDeserialize(`as` = Array<Ticket>::class)
    var collection: HashSet<Ticket> = HashSet<Ticket>()
    var scan = Scanner(System.`in`)
    var scriptWorks: Boolean = false
}