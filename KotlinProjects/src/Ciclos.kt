fun main() {
    val listaDeFrutas = listOf("Manzana", "Pera","Frambuesa","Durazno")
    for (fruta in listaDeFrutas){
        println("Hoy voy a comerme una fruta llamada $fruta")
    }

    listaDeFrutas.forEach { fruta-> println("Hoy me voy a comer una fruta nueva llamada $fruta") }

    val caracteresDeFruta: List<Int> = listaDeFrutas.map { fruta -> fruta.length }
    println(caracteresDeFruta)

    val listafiltrada = caracteresDeFruta.filter { largocaracteresDeFruta -> largocaracteresDeFruta > 5 }
    println(listafiltrada)
} 