//Ejercicio 3.5

class Coche(
    val marca: String?, val modelo: String, var gasolina: Float,
    val color: String = "Blanco", var tanque: Float, var variacionVelocidad: Int = 5,
    var velocidadMax: Int, var factorGasto: Double, var numeroMarchas: Int
) {
    var velocidad = 0
    var marcha = 0
    var gasto = 0.0
    private var estado = "Apagado"

    init {
        require(marca != null) { "Debes introducir un valor para marca." }
        //require(velocidad > 250 && velocidad < 10){"La velocidad debe estar en un valor entre 10 y 250"}
    }


    fun encender(): Boolean {
        return if (marcha == 0 && estado == "Apagado") {
            estado = "Encendido"
            gasolina > 0.0
        } else false
    }

    fun apagar() {
        parar()
        if (estado == "Encendido") estado = "Apagado"
    }

    fun iniciar() {
        if (estado == "Encendido" && velocidad == 0) marcha = 1; acelerar()
    }

    fun acelerar(): Int {
        return if (gasolina > 0) {
            if (velocidad < velocidadMax) velocidad += variacionVelocidad
            if (velocidad > velocidadMax) velocidad = velocidadMax
            velocidad
        } else {
            parar()
            velocidad
        }
    }

    fun gasto(marcha: Int): Double {
        when (marcha) {
            1 -> gasto = 5 * factorGasto
            2 -> gasto = 4 * factorGasto
            3 -> gasto = 3 * factorGasto
            4 -> gasto = 2 * factorGasto
            5 -> gasto = 1 * factorGasto
            else -> gasto = 0.0
        }
        return gasto
    }

    fun incrementaMarcha() {
        if (marcha < numeroMarchas) marcha++
    }

    fun decrementaMarcha() {
        if (marcha > 0) marcha--
    }

    fun frenar(): Int {
        if (velocidad > 0) velocidad -= variacionVelocidad
        if (velocidad < 0) velocidad = 0
        gasto(marcha)
        return velocidad
    }

    fun parar(): Boolean {
        while (velocidad != 0) {
            frenar()
        }
        marcha = 0
        return velocidad == 0
    }
}


fun main() {

}