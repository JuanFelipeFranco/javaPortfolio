fun main() {
    val listaDeNombres = listOf("Juan","Enrique","Camila")
    println(listaDeNombres)

    val listavacia = mutableListOf<String>()
    println(listavacia)
    //agregando (add)
    listavacia.add("Juan")
    println(listavacia)

    //obteniendo el valor de la lista (get)
    val valorGet = listavacia.get(0)
    println(valorGet)
    //otra forma
    val valorUsandoOperador = listavacia[0]
    println(valorUsandoOperador)
    //otra manera, solo obtiene el primer elemento o manda el null
    val primerValor: String? = listaDeNombres.firstOrNull()
    print(primerValor)

    //Eliminando a un index de la lista mutable
    listavacia.removeAt(0)
    println(listavacia)
    //Eliminar cumpliendo la condicion
    listavacia.add("Enrique")
    println(listavacia)
    listavacia.removeIf { caracteres -> caracteres.length > 3 }
    println(listavacia)

    //ARRAYS: usar en un codigo performances arrays pero lo recomendado es usar listas
    val myArray = arrayOf(1,2,3,4)
    println("Nuestro array $myArray")
    println("Array como lista ${myArray.toList()}")//convertir el array en una lista,
}