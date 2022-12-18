package t8K

fun main(){
    val bt: BinaryTree = BinaryTree()
    var readline: Int? = null
    while(readline != 0){
        println("0. Lopeta")
        println("1. Lisää")
        println("2. Hae")
        println("3. Poista")
        println("4. Auto")
        println("5. Tulosta")
        readline = readln().toInt()
        when(readline){
            1 -> {
                bt.insert(readln())
            }
            2 -> {
                bt.find(readln())
            }
            3 -> {
                bt.delete(readln())
            }
            4 -> {
                val testSet = arrayListOf<String>()
                testSet.addAll(listOf("test4","test3","test2","test5","test6","test0","test4", "test1"))
                for(s in testSet){
                    println("inserted: $s")
                    bt.insert(s)
                }

                println("Print: ")
                bt.printTree()
                /*
                for(i in testSet.indices){
                    println("Delete: " + testSet[i])
                    bt.delete(testSet[i])
                    bt.printTree()
                }

                println("Print: ")
                bt.printTree()
                */
            }
            5 -> {
                bt.printTree()
            }
        }
    }
}