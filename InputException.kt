import java.lang.Exception

class InputException(msg: String): Exception(msg) {
    fun cause(){
        super.cause
    }
}