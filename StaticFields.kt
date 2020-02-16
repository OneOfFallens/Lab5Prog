import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import commands.CommandManager
import commands.TicketComparator
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileInputStream
import java.util.*
import kotlin.collections.HashSet

object StaticFields {
    var buf_id: Long = 1
    var tcomp = TicketComparator()
    var fileout: java.io.FileOutputStream = java.io.FileOutputStream("collection.txt")
    var filein: FileInputStream = FileInputStream("collection.txt")
    var console: Console = Console()
    var arr = listOf<String>()
    val manager: CommandManager = CommandManager()
    @JsonDeserialize(`as` = Ticket::class)
    var collection: HashSet<Ticket> = HashSet<Ticket>()
    val scan = Scanner(System.`in`)

}