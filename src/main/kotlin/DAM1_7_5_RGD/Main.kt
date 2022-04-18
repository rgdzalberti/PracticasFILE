import java.io.File

/*
1 - > Representa jugador vivo
9 - > Área de juego restringida (Zona roja)
0 - > Área jugable sin ocupar
 */

class Juego(tiempo: Int, tablero : Array<IntArray>, posiciones: MutableList<Int>,tamaño: Int){

    var tiempo = tiempo
    var tablero = tablero
    val posiciones = posiciones
    val tamaño = tamaño

    fun situarJugadores(){

        fun separarNumerosA(numero: Int): Int{
            var caracter = numero.toString().get(0)
            return caracter.digitToInt()
        }

        fun separarNumerosB(numero: Int): Int{
            var caracter = numero.toString().get(1)
            return caracter.digitToInt()
        }

        for (i in 0 until posiciones.size)
        {
            tablero[separarNumerosA(posiciones[i])][separarNumerosB(posiciones[i])] = 1
        }


    }

    fun imprimirTablero(time: Int){
        println("=================")
        println("TIEMPO: " + time)
        for (i in tablero.indices) {
            println(tablero[i].contentToString())
        }
        println("=================")
    }

    fun reducirArea() {


        /*
        for (h in 0 until tablero.size) {

            for (i in 0 until tablero.size) {

                if (tablero[h][i] != ) {
                }

            }

        }

         */

    }

    fun jugar(){

        var minutosPasados = 0
        var tiempoRestante = tiempo

        for (i in 0 until tablero.size){
            var up = 0
            var down = tamaño - 1

            if (tablero[up][0] != 9) {tablero[up][i] = 9} else up++
            if (tablero[tamaño - 1][i] != 9) {tablero[tamaño - 1][i] = 9} else down--

            for(i in 1 until tablero.size - 1) {
                tablero[]
            }

            /*
            if (tablero[i][0] != 9) {tablero[i][0] = 9}
            tablero[0][i] = 9

             */
        }

        imprimirTablero(15)

        /*
        repeat(tiempo + 1)
        {
            situarJugadores()
            imprimirTablero(tiempoRestante)
            tiempoRestante--
            minutosPasados++

            if (minutosPasados == 10)
            {
                reducirArea()
                minutosPasados = 0
            }

        }

         */

    }

}


fun main(args: Array<String>) {

    //println("Program arguments: ${args.joinToString()}")

    val file = "C:\\Users\\Ricar\\Downloads\\battle.txt"
    val listaFile = mutableListOf<String>()
    File(file).forEachLine { listaFile.add(it) }
    listaFile.removeLast()

    val tamaño = listaFile.first().get(0).digitToInt()

    val tablero = Array(listaFile.first().get(0).digitToInt()) { IntArray(listaFile.first().get(0).digitToInt()) }
    var tiempo = listaFile[1].toInt()
    val posicionesString = mutableListOf<String>()
    val posicionesInt = mutableListOf<Int>()

    for (i in 0 until listaFile.size){
        listaFile[i] = listaFile[i].replace("\\s".toRegex(), "")
    }

    //Meto las posiciones en una lista separada
    for (i in 2 until listaFile.size)
    {
        if (listaFile[i].isNotEmpty()) {
            posicionesString.add(listaFile[i])
        }
    }
    //En esa lista separada ahora la paso a una lista en la que trabajaré con los números
    posicionesString.forEach { posicionesInt.add(it.toInt())}

    val jugar = Juego(tiempo,tablero, posicionesInt,tamaño)

    jugar.jugar()


}