package commands

/**
 * Абстрактный класс команды, являющийся родителем для всех классов команд.
 */
abstract class AbstractCommand {
    abstract var cmd: String
    abstract var info: String
    /**
     * Абстрактный метод, реализующий выполнение команд
     */
    abstract fun execute()

}