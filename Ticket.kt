import com.fasterxml.jackson.annotation.JsonAutoDetect
import java.time.ZonedDateTime
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.time.LocalDateTime
import kotlin.reflect.KClass
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder


@JsonAutoDetect
@JsonDeserialize(`as` = Ticket::class)
public class Ticket: Comparable<Ticket>  {
    @JsonProperty("id")
    private val tid: Long
    @JsonProperty("name")
    private val tname: String
    @JsonDeserialize(`as` = Coordinates::class)
    @JsonProperty("coordinates")
    private val tcoordinates: Coordinates
    @JsonDeserialize(`as` = java.time.LocalDateTime::class)
    @JsonProperty("creation time")
    private val tcreationDate: java.time.LocalDateTime
    @JsonProperty("price")
    private val tprice: Long
    @JsonProperty("type")
    private val ttype: TicketType?
    @JsonDeserialize(`as` = Person::class)
    @JsonProperty("person")
    private val tperson: Person
    constructor(id: Long, name: String, coordinates: Coordinates, creationDate: java.time.LocalDateTime, price: Long, type: TicketType?, person:Person){
        this.tid = id
        this.tname = name
        this.tcoordinates = coordinates
        this.tcreationDate = creationDate
        this.tprice = price
        this.ttype = type
        this.tperson = person
    }
    val id: Long
         get() = this.tid
    val price: Long
         get() = this.tprice
    val type: TicketType?
         get() = this.ttype
    val coordinates: Coordinates
         get() = this.tcoordinates
    val creationDate: java.time.LocalDateTime
         get() = this.tcreationDate
    val name: String
         get() = this.tname

    val person: Person
         get() = this.tperson
    override fun compareTo(t: Ticket): Int {
        return (this.id - t.tid).toInt()
    }

    override fun toString(): String {
        return "Ticket(id=$tid, name='$tname', coordinates=$tcoordinates, creationDate=$tcreationDate, price=$tprice, type=$ttype, person=$tperson)"
    }



}