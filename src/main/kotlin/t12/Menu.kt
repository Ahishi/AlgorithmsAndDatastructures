package t12
fun main(){
    val maxSize = 200;
    val priorityQueue = PriorityQueue(maxSize)
    var readline: Int? = null
    while(readline != 0){
        println("0. Lopeta")
        println("1. Lisää")
        println("2. Poista")
        println("3. Tulosta")
        readline = readln().toInt()
        when(readline){
            1 -> {
                val input = readln().toInt()
                if(input <= maxSize){
                    priorityQueue.insert(input)
                } else {
                  println("Täytyy olla numero ja pienempi kuin 200.")
                }
            }
            2 -> {
                val removed = priorityQueue.remove()
                println("Poistettiin pienin: $removed")
            }
            3 -> {
                priorityQueue.print()
            }
        }
    }
}