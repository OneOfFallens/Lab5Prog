package commands

import Console
import Person
import Ticket
import TicketType
import Coordinates
import Location
import InputException
import Storage
import java.time.LocalDateTime

/**
 * Класс, реализующий команду add, доавляющую элемент в коллекцию
 */
class Add constructor(gstor: Storage): AbstractCommand() {
    override var cmd = "add"
    override var info = "добавляет новый элемент в коллекцию"
    var stor = gstor
    /**
     * Метод, отвечающий за выполнение команды
     */
    override fun execute(console: Console) {
        var id: Long =  console.stor.pbuf_id

        console.stor.setBufId(console.stor.pbuf_id + 1)
        var name: String
        var coordinates: Coordinates
        var creationDate: String = LocalDateTime.now().toString()
        //var creationDate: String = "${LocalDateTime.now().dayOfMonth} ${LocalDateTime.now().month} ${LocalDateTime.now().year}"
        var price: Long
        var type: TicketType? = null
        while(true) {
            if (!console.stor.pscriptWorks) {
                print("Введите название: ")
            }
                try {
                    name = console.stor.pscan.nextLine() ?: throw InputException("Строка не может быть null")
                    if (name == "") {
                        throw InputException("Строка не может быть пустой")
                    }
                    break
                } catch (e: InputException) {
                    println(e)
                    return
                }
            }

        var strx: String
        var x: Long
        while(true) {
            if (!console.stor.pscriptWorks) {
                print("Введите координату по Х: ")
            }
            try {
                strx = console.stor.pscan.nextLine() ?: throw InputException("Строка не подходит по формату")
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
            if (!console.stor.pscriptWorks) {
                print("Введите координату по Y: ")
            }
            stry = console.stor.pscan.nextLine() ?: throw InputException("Число не подходит по формату")
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
            if (!console.stor.pscriptWorks) {
                print("Введите цену: ")
            }
        try {
            strprice = console.stor.pscan.nextLine() ?: throw InputException("Введенная строка не подходит по формату, повторите ввод")
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
            if (!console.stor.pscriptWorks) {
                print("Введите тип билета (VIP, USUAL, BUDGETARY, CHEAP): ")
            }
        var strtype: String? = console.stor.pscan.nextLine()
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
                    if (console.stor.pscriptWorks){
                        console.stor.setScriptWorks(false)
                    }
                }
            }
        }
        var locx: Long
        var locy: Float
        var locz: Float
        while (true){
            if (!console.stor.pscriptWorks) {
                print("Введите координату по Х: ")
            }
            try {
                var strlocx: String = console.stor.pscan.nextLine() ?: throw InputException("Некорректное значение")
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
            if (!console.stor.pscriptWorks) {
                print("Введите координату по Y: ")
            }
            try {
                var strlocy: String = console.stor.pscan.nextLine() ?: throw InputException("Некорректное значение")
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
            if (!console.stor.pscriptWorks) {
                print("Введите координату по Z: ")
            }
            try {
                var strlocz: String = console.stor.pscan.nextLine() ?: throw InputException("Некорректное значение")
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
            if (!console.stor.pscriptWorks) {
                print("Введите название локации: ")
            }
            try {
                locname = console.stor.pscan.nextLine() ?: throw InputException("Введена пустая строка")
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
            if(!console.stor.pscriptWorks) {
                print("Введите рост человека: ")
            }
        try{ var strheight: String = console.stor.pscan.nextLine() ?: throw InputException("Получена пустая строка, повторите ввод")
        height = strheight.toFloat()
            if (height <= 0.0) {
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
            if (!console.stor.pscriptWorks) {
                print("Введите вес человека: ")
            }
            try{
            var strweight: String = console.stor.pscan.nextLine() ?: throw InputException("Введенная вами строка не соотвествует формату")
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
        console.stor.pcollection.add(newTicket)
        println("Элемент создан, ему присвоено id = ${console.stor.pbuf_id-1}")
    }
    fun getString(){

    }
}