fun main() {
    val numeroLoteria = listOf(11,22,43,56,78,66)
    println(numeroLoteria)
    //ordenar la lista
    val numerosSorted = numeroLoteria.sorted()
    println(numerosSorted)
    //ordenado de mayor a menor
    val numeroLoteriaDescendiente = numeroLoteria.sortedDescending()
    println(numeroLoteriaDescendiente)
    //ordenar dependiendo de una condicion
    val ordenarMultiplos = numeroLoteria.sortedBy { numero -> numero<50 }
    println(ordenarMultiplos)
    //ordenar la lista de forma aleatoria
    val numerosAleatorios = numeroLoteria.shuffled()
    println(numerosAleatorios)
    //ordenar la lista de atras para adelante
    val numerosEnReversa = numeroLoteria.reversed()
    println(numerosEnReversa)
    //convertir y filtrar elementos con MAP
    val mensajeNumero = numeroLoteria.map { numero -> "Tu numero de loteria es $numero"}
    println(mensajeNumero)
    //numeros filtrados.
    val numerosFiltrados = numeroLoteria.filter { numero -> numero>50 }
    println(numerosFiltrados)
}