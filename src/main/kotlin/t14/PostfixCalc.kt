package t14

import java.util.*

class PostfixCalc {
    fun calculatePostFix(exp: String): Int{
        val stack: Stack<Int> = Stack()
        for(element in exp) run {
            val c: Char = element

            if(Character.isDigit(c)){
                stack.push(c-'0')
            } else {
                val val1 = stack.pop()
                val val2 = stack.pop()

                when(c){
                    '+' -> stack.push(val2 + val1)
                    '-' -> stack.push(val2 - val1)
                    '/' -> stack.push(val2 / val1)
                    '*' -> stack.push(val2 * val1)
                    else -> {}
                }
            }
        }
        return stack.pop()
    }
}