import com.fasterxml.jackson.annotation.JsonProperty

public class Coordinates {
    @JsonProperty("x")
    private var cx: Long = 0
    @JsonProperty("y")
    private var cy: Double = 0.0
    constructor(x: Long, y: Double){
        this.cx = x
        this.cy = y
    }
    constructor(){

    }

    override fun toString(): String {
        return "Coordinates(x=$cx, y=$cy)"
    }

}