package t1.stack

class Stack() {
    private var storageObject: ListItem? = null
    private var amount: Int = 0

    fun push(data: String){
        storageObject = ListItem(data, storageObject)
        amount++
    }

    fun pop(): ListItem?{
        val deletedObject = storageObject
        storageObject = storageObject?.next
        amount--
        return deletedObject
    }

    fun display(){
        var pointer: ListItem? = storageObject
        while (pointer !== null){
            println(pointer.data)
            pointer = pointer.next
        }
    }

    fun amount(): Int {
        return amount
    }
}