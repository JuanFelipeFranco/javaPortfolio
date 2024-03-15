fun main() {
    val moviles = mutableListOf("Redmi 9","Iphone 11","Iphone 12","Iphone 13","Redmi 10")
        .run {
            removeIf { movil -> movil.contains("Iphone") }
            this
        }
    println(moviles)
}