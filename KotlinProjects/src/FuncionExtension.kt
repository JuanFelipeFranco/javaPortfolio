fun main(args: Array<String>) {
    val frase ="En platzi no paramos de aprender".randomCase()
    imprimir(frase)
}

fun imprimir(frase: String):Unit{
    println("tu frase es: $frase")


}

fun String.randomCase():String{
    val numeroAleatorio = 0..99 //rango del numero aleatorio
    val resultadoAleatorio = numeroAleatorio.random() //

    //la operacion que devuelve el residuo este se llama rem.
    return if (resultadoAleatorio.rem(2)==0){
        this.toUpperCase() //si el residuo es ==0 (osea par) devuelve la frase en MAYUSCULA
    }else{
        this.toLowerCase() //si el residuo es diferente de 0(es impar) devuelve la frase en minuscula.
    }
}