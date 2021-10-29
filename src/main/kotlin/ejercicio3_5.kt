//Ejercicio 3.5

class Coche(
    val marca: String, val modelo: String, var gasolina: Double,
    val color: String = "Blanco", var tanque: Double, var variacionVelocidad: Int = 5,
    var velocidadMax: Int, var factorGasto: Double, var numeroMarchas: Int
)
{
    companion object{
        fun comparar(coche1:Coche, coche2:Coche):String{
            return if(coche1.velocidad > coche2.velocidad) "$coche1 es más rápido"
            else "$coche2 es más rápido"
        }
    }

    var velocidad = 0
    var marcha = 0
    var estado = "Apagado"

    init {

        //require(marca != null) { "Debes introducir un valor para marca." } -> Nunca se da esta situación.
        require(numeroMarchas in 1..5) { "El numero de marchas debe estar entre el 1 y el 5." }
        require(velocidadMax in 10..250) { "La velocidad máxima debe estar entre 10 y 250." }
        require(factorGasto > 0.0) { "El factor gasto debe ser mayor a 0." }
        require(variacionVelocidad > 0) { "La variación de velocidad debe ser mayor a 0." }
        require(gasolina > 0.0 && gasolina <= tanque) { "No has introducido un valor correcto para la gasolina." }
        require(tanque > 0) { "El tanque debe ser mayor a 0." }
        require(color.isNotEmpty()) { "No puedes introducir un string vacío." }
        require(marca.isNotEmpty()) { "No puedes introducir un string vacío." }

    }

    fun encender(): Boolean {
        return if (marcha == 0 && estado == "Apagado") {
            estado = "Encendido"
            gasolina > 0.0
        } else false
    }

    fun apagar(): String {
        if (estado == "Encendido") {
            if (velocidad == 0 && marcha == 0) estado = "Apagado"
        }
        return estado
    }

    fun iniciar() {
        if (estado == "Encendido" && velocidad == 0) marcha = 1; acelerar()
    }

    fun acelerar(): Int {
        if (estado == "Encendido" && marcha > 0) {
            if (gasolina > 0) {
                if (velocidad < velocidadMax) velocidad += variacionVelocidad
                if (velocidad > velocidadMax) velocidad = velocidadMax
            } else {
                parar()
            }
        }
        return velocidad
    }

    private fun gasto(marcha: Int){
        gasolina -= when (marcha) {
            1 -> 5 * factorGasto
            2 -> 4 * factorGasto
            3 -> 3 * factorGasto
            4 -> 2 * factorGasto
            5 -> 1 * factorGasto
            else -> 0.0
        }
        if (gasolina < 0.0) gasolina = 0.0
    }

    fun incrementaMarcha() {
        if (marcha < numeroMarchas) marcha++
    }

    fun decrementaMarcha() {
        if (marcha > 1) marcha-- //Cambiado con respecto al enunciado
    }

    fun frenar(): Int {
        if (estado == "Encendido") {
            if (velocidad > 0) velocidad -= variacionVelocidad
            if (velocidad < 0) velocidad = 0
            gasto(marcha)
        }
        return velocidad
    }

    fun parar(): Boolean {
        while (velocidad != 0) {
            frenar()
        }
        marcha = 0
        return velocidad == 0
    }

    override fun toString(): String {
        return "$marca $modelo"
    }
}


fun main() {

    val coche1 = Coche(
        "Citroen",
        "Passat",
        50.0,
        tanque = 50.0,
        variacionVelocidad = 7,
        velocidadMax = 210,
        factorGasto = 2.0,
        numeroMarchas = 5
    )

    val coche2 = Coche(
        "Volkswagen",
        "A2",
        60.0,
        tanque = 75.0,
        variacionVelocidad = 6,
        velocidadMax = 220,
        factorGasto = 1.8,
        numeroMarchas = 5
    )

    println(coche1.estado)
    coche1.encender()
    println(coche1.estado)
    coche1.iniciar()
    println(coche1.velocidad)
    coche1.acelerar()
    println(coche1.velocidad)
    coche1.incrementaMarcha()
    coche1.acelerar()
    println("gasolina: " + coche1.gasolina)
    println(coche1.velocidad)
    coche1.frenar()
    println(coche1.velocidad)

    coche2.encender()
    coche2.iniciar()
    coche2.acelerar()
    coche2.incrementaMarcha()
    coche2.incrementaMarcha()
    coche2.acelerar()
    coche2.acelerar()
    coche2.decrementaMarcha()

    println(Coche.comparar(coche1, coche2))

    coche2.parar()
    coche2.apagar()

    coche1.apagar()
    println(coche1.estado)
    println(coche1.gasolina)
    coche1.parar()
    println(coche1.gasolina)
    println(coche1.velocidad)
    coche1.apagar()
    println(coche1.estado)
}