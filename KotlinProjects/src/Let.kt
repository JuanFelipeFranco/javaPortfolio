fun main() {
    //let ejecuta codigo cuando el valor no es nulo
    var nombre:String? = null
    nombre?.let{
        //el codigo no se ejecutara porque el valor de la variable es nula
        valor -> println("El nombre no es nulo, es $valor")
    }

    nombre = "Juan"
    //self calls(?.let) nos permite correr el código para un valor que no es nulo
    nombre?.let { valor -> println("Este valor no es nulo, es $valor") }
}