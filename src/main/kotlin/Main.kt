
//EJERCICIO 3.1
/*
fun main() {
    val entero = 1
    val mipar = Pair(2,3)
    println("Utilizo el método .inc para incrementar mi objeto de la clase Int = $entero a ${entero.inc()}")

    println(mipar.first + mipar.second)
}*/

//EJERCICIO 3.2
/*
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name"
    init
    {   println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}"
    init
    {   println("Second initializer block that prints ${name.length}")
    }
}

fun main(){
    val demo = InitOrderDemo("Hola")
}*/

//EJERCICIO 3.3 && 3.4
class Coche(val marca:String){

    val modelo:String
    val color:String 

    constructor(marca:String,  modelo:String, velocidadMax:Int, color:String):this(marca){
        require(velocidadMax in 11..249){"Esa velocidad no está permitida"}

    }

    init {
        require(marca != null){"Marca no puede ser nulo"}
    }

    fun encender(){
        if (!encendido){
            println("El coche se ha encendido")
            encendido = true
        } else println("El coche ya está encendido")

    }


}

fun main(){
    val coche1 = Coche("Citroen","A1",200,"Negro")
}