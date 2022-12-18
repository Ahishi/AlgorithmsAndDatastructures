package t14

import java.lang.Thread.sleep
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayDeque

fun main(){
    val infix = "(3+4)*(5/2)"
    val postfix = Postfix()
    val postfixCalculator = PostfixCalc()
    val ans = postfix.calculate(infix)
    println("\nPostfix expression: $ans")
    println("Answer is: " + postfixCalculator.calculatePostFix(ans))
}

class Postfix {

    private var stack: ArrayDeque<Char> = ArrayDeque()
    private var ans: String = ""

    fun calculate(infix: String): String{
        val infixArray: CharArray = infix.toCharArray()
        for(char in infixArray){
            when (char) {
                '+', '-' -> {
                    for((i, operand) in stack.withIndex()){
                        if(operand == '+' || operand == '-'){
                            ans += stack.removeAt(i)
                            break
                        }
                    }
                    stack.add(char)
                }
                '*', '/' -> {
                    for((i, operand) in stack.withIndex()){
                        if(operand == '*' || operand == '/'){
                            ans += stack.removeAt(i)
                            break
                        }
                    }
                    stack.add(char)
                }
                ')' -> {
                    for((i, operand) in stack.withIndex()){
                        if(operand == '('){
                            stack.removeAt(i)
                            for(i2 in i until stack.size){
                                ans += stack[i+i2]
                            }
                            for(i2 in i until stack.size){
                                stack.removeAt(i+i2)
                            }
                            break
                        }
                    }
                }
                '(' -> {
                  stack.add(char)
                }
                else -> {
                    ans += char
                }
            }

            print("\nPostfix Stack: ")
            println(ans)

            print("Operand Stack: ")
            stack.forEach(){ print(it) }
            println()
        }

        return ans
    }
}