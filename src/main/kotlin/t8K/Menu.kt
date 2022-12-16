package t8K

fun main(){
    val bt: BinaryTree = BinaryTree()
    var readline: Int? = null
    while(readline != 0){
        println("0. Lopeta")
        println("1. Lisää")
        println("2. Hae")
        println("3. Poista")
        println("4. Tulosta")
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
                bt.printTree()
            }
        }
    }
}