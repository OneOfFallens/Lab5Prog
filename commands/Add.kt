package commands

import StaticFields.collection
import StaticFields.console
import Person
import Ticket
import TicketType
import Coordinates
import Location
import InputException
import StaticFields.buf_id
import StaticFields.scan
import StaticFields.scriptWorks
import java.time.LocalDateTime

/**
 * Класс, реализующий команду add, доавляющую элемент в коллекцию
 */
class Add: AbstractCommand() {
    override var cmd = "add"
    override var info = "добавляет новый элемент в коллекцию"
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute() {
        var id: Long = StaticFields.buf_id
        StaticFields.buf_id += 1
        var name: String
        var coordinates: Coordinates
        var creationDate: String = LocalDateTime.now().toString()
        //var creationDate: String = "${LocalDateTime.now().dayOfMonth} ${LocalDateTime.now().month} ${LocalDateTime.now().year}"
        var price: Long
        var type: TicketType? = null
        while(true) {
            if (!scriptWorks) {
                print("Введите название: ")
            }
            try {
                name = scan.nextLine() ?: throw InputException("Строка не может быть null")
                if (name == "") {
                    throw InputException("Строка не может быть пустой")
                }
                break
            }
            catch(e: InputException){
                println(e)
                return
            }
        }
        var strx: String
        var x: Long
        while(true) {
            if (!scriptWorks) {
                print("Введите координату по Х: ")
            }
            try {
                strx = scan.nextLine() ?: throw InputException("Строка не подходит по формату")
                x = strx.toLong()
                break
            }
            catch(e: InputException){
                println(e)
            }
            catch(e: java.lang.NumberFormatException){
                println(e)
            }
        }
        var stry: String
        var y: Double = 0.0
        try {
            if (!scriptWorks) {
                print("Введите координату по Y: ")
            }
            stry = scan.nextLine() ?: throw InputException("Число не подходит по формату")
            y = stry.toDouble()
            if (y< -103){
                throw InputException("Число не входит в заданный диапазон")
            }
        }
        catch(e: InputException){
            println(e)
        }
        catch(e: NumberFormatException){
            println(e)
        }
        coordinates = Coordinates(x, y)
        var strprice: String
        while(true){
            if (!scriptWorks) {
                print("Введите цену: ")
            }
        try {
            strprice = scan.nextLine() ?: throw InputException("Введенная строка не подходит по формату, повторите ввод")
            price = strprice.toLong()
            if (price < 0){
                throw InputException("Числовое значение некорректно, поторите ввод")
            }
            break
        }
        catch(e: InputException){
            println(e)
        }
        catch(e: NumberFormatException){
            println(e)
        }
        }
        var noType = true
        while (noType) {
            if (!scriptWorks) {
                print("Введите тип билета (VIP, USUAL, BUDGETARY, CHEAP): ")
            }
        var strtype: String? = scan.nextLine()
        var eType = InputException("То, что вы ввели, не является типом билета, повторите ввод")
            when (strtype) {
                "VIP" -> {
                    type = TicketType.VIP
                    noType = false
                }
                "USUAL" -> {
                    type = TicketType.USUAL
                    noType = false
                }
                "BUDGETARY" -> {
                    type = TicketType.BUDGETARY
                    noType = false
                }
                "CHEAP" -> {
                    type = TicketType.CHEAP
                    noType = false
                }
                null -> {
                    type = null
                    noType = false
                }
                "" -> {
                    type = null
                    noType = false
                }
                else -> {
                    println(eType)
                    if (scriptWorks){
                      scriptWorks = false
                    }
                }
            }
        }
        var locx: Long
        var locy: Float
        var locz: Float
        while (true){
            if (!scriptWorks) {
                print("Введите координату по Х: ")
            }
            try {
                var strlocx: String = scan.nextLine() ?: throw InputException("Некорректное значение")
                locx = strlocx.toLong()
                break
            }
            catch(e: InputException){
                println(e)
            }
            catch(e: NumberFormatException){
                println(e)
            }
        }
        while (true){
            if (!scriptWorks) {
                print("Введите координату по Y: ")
            }
            try {
                var strlocy: String = scan.nextLine() ?: throw InputException("Некорректное значение")
                locy = strlocy.toFloat()
                break
            }
            catch(e: InputException){
                println(e)
            }
            catch(e: NumberFormatException){
                println(e)
            }
        }
        while (true){
            if (!scriptWorks) {
                print("Введите координату по Z: ")
            }
            try {
                var strlocz: String = scan.nextLine() ?: throw InputException("Некорректное значение")
                locz = strlocz.toFloat()
                break
            }
            catch(e: InputException){
                println(e)
            }
            catch(e: NumberFormatException){
                println(e)
            }
        }
        var locname: String
        while (true) {
            if (!scriptWorks) {
                print("Введите название локации: ")
            }
            try {
                locname = scan.nextLine() ?: throw InputException("Введена пустая строка")
                if (locname.length > 852){
                    throw InputException("Слишком длинная строка, повторите ввод")
                }
                break
            }
            catch(e: InputException){
                println(e)
            }
        }
        val location = Location(locx, locy, locz, locname)
        var height: Float
        while(true){
            if(!scriptWorks) {
                print("Введите рост человека: ")
            }
        try{ var strheight: String = scan.nextLine() ?: throw InputException("Получена пустая строка, повторите ввод")
        height = strheight.toFloat()
            if (height < 0.0) {
                throw InputException("Число не подходит по формату")
            }
        break}
        catch(e: NumberFormatException){
            println(e)
        }
        catch(e: InputException){
            println(e)
        }}
        var weight: Double?
        while(true) {
            if (!scriptWorks) {
                print("Введите вес человека: ")
            }
            try{
            var strweight: String = scan.nextLine() ?: throw InputException("Введенная вами строка не соотвествует формату")
            weight = strweight.toDouble()
                if (weight < 0.0) {
                    throw InputException("Введенная вами строка не соотвествует формату")
                }
                break}
                catch(e: InputException){
                    println(e)
                }
            catch(e: NumberFormatException){
                println(e)
            }
        }
        val person: Person = Person(height, weight, location)
        val newTicket: Ticket = Ticket(id, name, coordinates, creationDate, price, type, person)
        collection.add(newTicket)
        println("Элемент создан, ему присвоено id = ${buf_id-1}")
    }
    fun getString(){

    }
}