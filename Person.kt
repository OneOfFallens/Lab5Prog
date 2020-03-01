import com.fasterxml.jackson.annotation.JsonProperty

class Person {
    @JsonProperty("weight")
    private var pheight: Float = 0.0F
    @JsonProperty("height")
    private var pweight: Double? = 0.0
    @JsonProperty("location")
    private var plocation: Location? = null
    constructor(height: Float, weight: Double?, location: Location?){
        this.pweight = weight
        this.pheight = height
        this.plocation = location
    }
    constructor(){

    }

    override fun toString(): String {
        return "Person(height=$pheight, weight=$pweight, location=$plocation)"
    }
}