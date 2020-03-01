package commands

/**
 * Класс. реализующий объект, управляющий всеми командами.
 */
class CommandManager{
    val add: Add = Add()
    val clear: Clear = Clear()
    val exit = Exit()
    val filterByPrice = FilterByPrice()
    val filterLessThanType = FilterLessThanType()
    val info = Info()
    val removeById = RemoveById()
    val show = Show()
    val update = Update()
    val help = Help()
    val jack = SaveJackson()
    val addIfMax = AddIfMax()
    val addIfMin = AddIfMin()
    val executeScript = ExecuteScript()
    val removeLower = RemoveLower()
    val printAscending = PrintAscending()
    var commands: HashSet<AbstractCommand> = hashSetOf(add, addIfMax, clear, addIfMin, removeLower, exit, executeScript, help, printAscending, filterByPrice,  filterLessThanType, jack, info, removeById, show, update)

}