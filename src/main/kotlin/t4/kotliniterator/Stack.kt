package t4.kotliniterator

class Stack {
    private val arr: Array<ListItem?> = Array(9999){ null }

    fun push(s: String){
        for(i in 0 until arr.size){
            if (arr[i] == null) {
                val item = ListItem(s)
                arr[i] = item
                break
            }
        }
    }

    fun pop(): ListItem? {
        for(i in arr.indices){
            if (arr[i] == null) {
                val pop = arr[i-1]
                arr[i-1] = null
                return pop
            }
        }
        return null
    }

    fun amount(): Int {
        for(i in arr.indices){
            if (arr[i] == null) {
                return i
            }
        }
        return 0
    }

    fun display() {
        for(li in arr){
            if (li != null) {
                println(li.data)
            }
        }
    }
}