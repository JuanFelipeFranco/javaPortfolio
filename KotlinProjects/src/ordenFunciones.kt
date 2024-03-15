fun main() {
    val largoValorInicial = superFuncion(valorInicial = "Hola") { valor ->
        valor.length
    }
    println(largoValorInicial)
}
//Valor inicial es el mensaje, la variable block es una sintaxis recomendada para nombrar las lambdas,
// event o listener cuando vamos a realizar una accion dependiendo un evento
fun superFuncion(valorInicial: String, block : (String) -> Int):Int{
    return block(valorInicial)
}