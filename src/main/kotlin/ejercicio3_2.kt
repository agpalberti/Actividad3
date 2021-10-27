//Ejercicio 3.2

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
}