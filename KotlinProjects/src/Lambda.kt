fun main() {
    //val myLambda:(String) -> Int = { it.length }

    //De forma explicita y usando valor como parametro
    val myLambda:(String) -> Int = { valor -> valor.length }

    //obteniendo el valor (de la lambda
    val lambdaEjecutada = myLambda("Hola Platzi")
    println(lambdaEjecutada)


    //SALUDOS
    val saludos = listOf("Hello","Hola","Ciao")
    //pasamos mylamba como parametro lo que hace es comocar la linea 5 valor->valor.length y va ir pasando a cada uno de la lista de saludos.
    val longSaludos = saludos.map(myLambda)
    println(longSaludos)

    //lo que hace es como se ejecuta como parametro el lambda me ahorro el estar haciendolo para cada uno.

}