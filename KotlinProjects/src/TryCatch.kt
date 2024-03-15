fun main() {
    //tipo string anulable, y asignamos el valor nulo que es por donde empieza
    var nombre1:String? = null
//  evitar siempre el doble bang !! -> nombre!!.length, usar el safe calls
    try {
        throw NullPointerException("Referencia Nula")
        nombre1!!.length
    }catch (excepcion:NullPointerException){
        //capturando la excepcion
        println("Ha ocurrido un error")
    }finally {
        println("Ha ocurrido un error.. cerrando aplicacion")
    }

    val primervalor =10
    val segundovalor =0
    val resultado: Int = try {
        primervalor/segundovalor
    }catch(exception:Exception){0}
    println(resultado)

    //OPERATOR ELVIS
    var nombre:String? = null
    val caracteresdeNombre :Int = nombre?.length ?: 0
    print(caracteresdeNombre)
}

