class Location {
    private var lx: Long
    private var ly: Float
    private var lz: Float
    private var lname: String
    constructor(x: Long, y: Float, z: Float, name: String){
        this.lx = x
        this.ly = y
        this.lz = z
        this.lname = name
    }
    val x: Long
        get() = this.lx
    val y: Float
        get() = this.ly
    val z: Float
        get() = this.lz
    val name: String
        get() = this.lname
}