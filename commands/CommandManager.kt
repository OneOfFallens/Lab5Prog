package commands

import Console
import Storage
import java.util.*
import kotlin.collections.HashSet

/**
 * Класс. реализующий объект, управляющий всеми командами.
 */
class CommandManager{
    var stor = Storage("collection.json", 1L, false, Scanner(System.`in`), hashSetOf(), TicketComparator(), hashSetOf(), listOf())
    var console = Console(stor)
    val add: Add = Add(console.stor)
    val clear: Clear = Clear(console.stor)
    val exit = Exit()
    val filterByPrice = FilterByPrice(console.stor)
    val filterLessThanType = FilterLessThanType(console.stor)
    val info = Info(console)
    val removeById = RemoveById(console.stor)
    val show = Show(console.stor)
    val update = Update(console.stor)
    val help = Help(console.stor, this)
    val jack = SaveJackson(console.stor)
    val addIfMax = AddIfMax(console.stor)
    val addIfMin = AddIfMin(console.stor)
    val executeScript = ExecuteScript(console)
    val removeLower = RemoveLower(console.stor)
    val printAscending = PrintAscending(console.stor)
    var commands: HashSet<AbstractCommand> = hashSetOf(add, addIfMax, clear, addIfMin, removeLower, exit, executeScript, help, printAscending, filterByPrice,  filterLessThanType, jack, info, removeById, show, update)
    constructor(console: Console){
        this.console = console
    }
    constructor(){

    }
}