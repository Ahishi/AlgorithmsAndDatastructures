package t6

import java.util.LinkedList

class StackLinkedList {
    var linkedList = LinkedList<String>();

    fun push(input: String){
        linkedList.push(input)
    }

    fun pop(): String?{
        return linkedList.pop()
    }

    fun amount(): Int{
        return linkedList.size
    }

    fun display(){
        linkedList.forEach{ println(it) }
    }
}