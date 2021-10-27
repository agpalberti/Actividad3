//Ejercicio 3.5

class Coche(val marca:String?, val modelo:String, var gasolina:Float,
            val color:String = "Blanco", var tanque:Float, var variacionVelocidad:Int = 5,
            var velocidadMax:Int, var factorGasto:Double, var numeroMarchas:Int)
{
    var velocidad = 0
    var marcha = 0
    private var estado = "Apagado"

    init {
        require(marca != null){"Debes introducir un valor para marca."}
        //require(velocidad > 250 && velocidad < 10){"La velocidad debe estar en un valor entre 10 y 250"}
    }


    fun encender():Boolean{
        return if (marcha == 0 && estado != "Encendido") {
            estado = "Encendido"
            gasolina > 0.0
        }
        else false
    }

    fun apagar(){
        if(estado == "Encendido") estado = "Apagado" //TODO: INTRODUCIR VELOCIDAD EN APAGAR: SEA COMO REQUERIMIENTO O LLAMANDO A FRENAR
        else println("El coche ya está apagado")
    }

    fun iniciar(){

    }

    fun acelerar():Int{
        return if(gasolina > 0){
            velocidad += variacionVelocidad
            velocidad
        } else{
            parar()
            velocidad
        }
    }

    fun frenar():Int{
        velocidad -= variacionVelocidad
        if (velocidad<0) velocidad = 0
        return velocidad
    }

    fun parar():Boolean{
        while(velocidad != 0){
            frenar()
        }
        marcha = 0//TODO:
        return velocidad == 0
    }
}


fun main(){

}