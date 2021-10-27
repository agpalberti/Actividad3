//EJERCICIO 3.3 && 3.4

class Coche1(val marca:String){
    constructor(marca:String, modelo:String, velocidadMax:Int, color:String):this(marca){
        require(velocidadMax in 11..249){"Esa velocidad no está permitida"}

        val modelo = modelo
        val velocidadMax = velocidadMax
        val color = color

    }
}

fun main(){
    val coche1 = Coche1("Citroen","A1",200,"Negro")
}