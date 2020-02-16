class Person {
    private var pheight: Float
    private var pweight: Double?
    private var plocation: Location?
    constructor(height: Float, weight: Double?, location: Location?){
        this.pweight = weight
        this.pheight = height
        this.plocation = location
    }
    val height: Float
        get() = this.pheight
    val weight: Double?
        get() = this.pweight
    val location: Location?
        get() = this.plocation
}