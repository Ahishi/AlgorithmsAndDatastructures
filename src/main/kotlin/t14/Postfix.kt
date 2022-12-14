package t14

import java.lang.Thread.sleep
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayDeque

fun main(){
    val infix = "(3+4)*(5/2)"
    val postfix: Postfix = Postfix()
    println(postfix.calculate(infix))
}

class Postfix {

    private var stack: ArrayDeque<Char> = ArrayDeque()
    private val ans: Queue<Char> = LinkedList()

    fun calculate(infix: String){
        val infixArray: CharArray = infix.toCharArray()
        for(char in infixArray){
            when (char) {
                '+', '-' -> {
                    for((i, operand) in stack.withIndex()){
                        if(operand == '+' || operand == '-'){
                            val removed = stack.removeAt(i)
                            ans.add(removed)
                            break
                        }
                    }
                    stack.add(char)
                }
                '*', '/' -> {
                    for((i, operand) in stack.withIndex()){
                        if(operand == '*' || operand == '/'){
                            val removed = stack.removeAt(i)
                            ans.add(removed)
                            break
                        }
                    }
                    stack.add(char)
                }
                ')' -> {
                    for((i, operand) in stack.withIndex()){
                        if(operand == '('){
                            for(i2 in i+1 .. stack.lastIndex){
                                ans.add(stack.removeAt(i2))
                            }
                        }
                    }
                }
                '(' -> {
                  stack.add(char)
                }
                else -> {
                    ans.add(char)
                }
            }
            stack.forEach(){ print(it) }
            println()
        }

        print("\n\npostfix: ")
        ans.forEach(){
            print(it)
        }
        println("\n")
    }
}