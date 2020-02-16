public class Coordinates {
    private var cx: Long
    private var cy: Double
    constructor(x: Long, y: Double){
        this.cx = x
        this.cy = y
    }
    val x: Long
       get() = this.cx
    val y: Double
       get() = this.cy
}