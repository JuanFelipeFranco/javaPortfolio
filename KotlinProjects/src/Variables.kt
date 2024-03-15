//constantes se definen afuera de la funcion con la palabra const y val
//Se declara en tiempo de compilacion.
const val PI = 3.1416;
fun main() {
    println("Hello World!")
    //variable de lectura y escritura; se puede modificar.
    var dinero : Int = 10
    println("Tenemos "+dinero+"  pesos")
    dinero = 5
    println(dinero)
    //variable de lectura, y declarada en tiempo de ejecucion.
    val nombre = "Maria"
    println(nombre)
    println(PI)

    val boolean = true
    val numeroLargo:Long=3L
    val double : Double = 2.71712
    val float : Float = 1.1f

    val primerValor = 20
    val segundoValor = 10
    val tercerValor = primerValor.minus(segundoValor)
    println(tercerValor)
    val cuartoValor = primerValor-segundoValor
    println(cuartoValor)

    //cadena de texto.
    val apellido = "vetri"
    val giuseppe = "Giuseppe"
    val nombreCompleto = "Mi nombre es $giuseppe $apellido"
    println(nombreCompleto)

    val mayor = primerValor.compareTo(segundoValor)>=0
    println(mayor)
}