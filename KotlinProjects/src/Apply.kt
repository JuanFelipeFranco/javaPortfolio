fun main() {
    val telefonos = mutableListOf("Redmi 9", "Iphone 11", "Iphone 12", "Iphone 13", "Redmi 10").apply {
        removeIf { movil -> movil.contains("Iphone") }
    }
    println(telefonos)

    val colores : MutableList<String>? = null
    colores?.apply{
        println("Nuestros colores son $this")
        println("la cantida es $size")
    }

    val color : MutableList<String>? = mutableListOf("Rojo", "verde")
    color?.apply{
        println("Nuestros colores son $this")
        println("la cantida es $size")
    }

}