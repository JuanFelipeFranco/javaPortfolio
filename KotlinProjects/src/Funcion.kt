//funcion que podremos convertir una frase de mayuscula a minuscula
fun main() {
    //creamos la frase aleatoria.
    val fraseAleatoria = "En Platzi nunca paramos de aprender"
    //println(randomCase(fraseAleatoria)) //imprimimos e invocamos la funcion
    imprimirFrase(randomCase(fraseAleatoria))
}
//FUNCION UNIT.
fun imprimirFrase(frase: String):Unit{
    println("tu frase es: $frase")
}

//tenemos un numero al azaar entre 0 y 99 si el numero es divisible por 2 convierte la frase a Mayuscula y si no esto lo pasa a minuscula
fun randomCase(frase:String):String{
    val numeroAleatorio = 0..99 //rango del numero aleatorio
    val resultadoAleatorio = numeroAleatorio.random() //

    //la operacion que devuelve el residuo este se llama rem.
    return if (resultadoAleatorio.rem(2)==0){
        frase.toUpperCase() //si el residuo es ==0 (osea par) devuelve la frase en MAYUSCULA
    }else{
        frase.toLowerCase() //si el residuo es diferente de 0(es impar) devuelve la frase en minuscula.
    }
}