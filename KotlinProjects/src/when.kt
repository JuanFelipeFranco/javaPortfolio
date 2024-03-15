fun main(args:Array<String>) {
    val nombreColor = "Azul"

    when (nombreColor){
        "Amarillo"-> println("El amarillo es el color de la alegria")
        "Rojo","Escarlata"-> println("El rojo simboliza el amor")
        else -> println("Error. no tengo informacion del color")
    }

    val code = 510
    when (code){
        in 200..299 -> println("Todo ha sido bien")
        in 300..399-> println("Algo ha fallado")
        in 400..500-> println("Intenta de nuevo")
        else -> println("Codigo desconocido, algo ha fallado")

    }

    val tallaDeZapatos = 40
    val mensaje = when(tallaDeZapatos){
        40,41,42 -> println("Tenemos Disponible")
        43,44 -> println("Queda dos unidades disponibles de cada uno")
        45 -> println("No hay disponibilidad")
        else -> println("Tallas sin disponibilidad")
    }
}