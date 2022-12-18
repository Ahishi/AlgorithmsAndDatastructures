package t18

import t18.t8I.BinaryTree
import java.util.*

fun main(){
    val ts = TreeSet<Int>()
    val bt = BinaryTree()
    val testSetSize: Int = 100000
    val randomValues = (0..testSetSize).toList().shuffled()

    val ownTreeStartTime = System.nanoTime()
    for(i in 0 until testSetSize){
        bt.insert(randomValues[i])
    }
    var ownTreeEndTime = System.nanoTime() - ownTreeStartTime

    val treeSetStartTime = System.nanoTime()
    for(i in 0 until testSetSize){
        ts.add(randomValues[i])
    }
    var treeSetEndTime = System.nanoTime() - treeSetStartTime

    ownTreeEndTime /= 1000
    treeSetEndTime /= 1000

    println("Own tree: $ownTreeEndTime μs")
    println("Tree set: $treeSetEndTime μs")

}