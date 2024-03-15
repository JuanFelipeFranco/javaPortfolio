fun main() {
    //sets solo tiene en cuenta las primeras variables
    val vocalesRepetidas = setOf("a","e","i","o","u","u","a","e","i","o","u","q")
    println(vocalesRepetidas)

    val numerosfavoritos = mutableSetOf(1,2,3,4)
    println(numerosfavoritos)

    numerosfavoritos.add(5)
    println(numerosfavoritos)
    //set solo acepta un dato una vez
    numerosfavoritos.add(5)
    println(numerosfavoritos)
    //set se elimina dependiendo el valor y no la posicion
    numerosfavoritos.remove(0)
    println(numerosfavoritos)
    //obtenemos valor de un set que no tiene indice
    val valordeSet: Int? = numerosfavoritos.firstOrNull() { numero -> numero > 2 }
    println(valordeSet)




}