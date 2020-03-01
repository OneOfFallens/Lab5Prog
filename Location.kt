import com.fasterxml.jackson.annotation.JsonProperty

class Location {
    @JsonProperty("x")
    private var lx: Long = 0
    @JsonProperty("y")
    private var ly: Float = 0.0F
    @JsonProperty("z")
    private var lz: Float = 0.0F
    @JsonProperty("name")
    private var lname: String = ""
    constructor(x: Long, y: Float, z: Float, name: String){
        this.lx = x
        this.ly = y
        this.lz = z
        this.lname = name
    }
    constructor(){

    }
}