package t2.queue

class Queue() {
    private var storageObject: ListItem? = null
    private var amount: Int = 0

    fun push(data: String){
        if(storageObject === null){
            storageObject = ListItem(data, null)
        } else {
            var pointer: ListItem? = storageObject
            while (pointer?.next !== null){
                pointer = pointer.next
            }
            pointer?.next = ListItem(data, null)
        }
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