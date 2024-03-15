//elementos de clave valor, cada clave tiene asignado un valor. Estructura de datos.
fun main() {
    //mapas inmutables: no se deja modificar nada.
    val edadSuperHeroes = mapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99
    )
    println(edadSuperHeroes)

    val edadSuperHeroesMutable = mutableMapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99
    )
    println(edadSuperHeroesMutable)

    //Agregando super heroes mutables
    edadSuperHeroesMutable.put("Wolverine",45)
    println(edadSuperHeroesMutable)

    edadSuperHeroesMutable["Storm"]=30
    println(edadSuperHeroesMutable)

    //obteniendo un valor del mapa
    val edadIronman = edadSuperHeroesMutable["Ironman"]
    println(edadIronman)

    //eliminando del map
    edadSuperHeroesMutable.remove("Wolverine")
    println(edadSuperHeroesMutable)

    //conocer tod los valores de un mapa, obtenemos nombre de las llaves pero no los valores
    println(edadSuperHeroesMutable.keys)
    //obtendremos solo los valores de cada una de las keys
    println(edadSuperHeroesMutable.values)
}