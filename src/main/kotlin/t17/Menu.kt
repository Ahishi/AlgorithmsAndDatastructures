package t17

import java.util.*

fun main(){
    val ts = TreeSet<Int>();
    var readline: Int? = null
    while(readline != 0){
        println("0. Lopeta")
        println("1. Lisää")
        println("2. Hae")
        println("5. Tulosta")
        readline = readln().toInt()
        when(readline){
            1 -> {
                ts.add(readln().toInt())
            }
            2 -> {
                val search = readln().toInt()
                println(ts.find{it == search})
            }
            5 -> {
                ts.forEach { println(it) }
            }
        }
    }
}