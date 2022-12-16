package t13

import java.util.*

fun main() {
    val hashMap = HashM(25)

    do {
        println("To stop: 0 \nTo add: 1 \nTo search 2 \nTo display 3")
        val input = readln().toInt()

        when (input) {
            1 -> {
                hashMap.add(readln())
            }

            2 -> {
                val hashResult = hashMap.get(readln())
                if (hashResult != null) {
                    println(hashResult)
                } else {
                    println("No such value in storage!")
                }
            }

            3 -> {
                hashMap.display()
            }
        }
    } while (input != 0)
}

class HashM(hashMapSize: Int) {
    private val storage: Array<LinkedList<HashObject?>> =
        Array(hashMapSize) { LinkedList<HashObject?>() } //Linked list for collision safety

    private fun hashIndex(s: String): Int {
        val charArrayedString = s.toCharArray()
        var combinedAscii = 0
        for (char in charArrayedString) {
            combinedAscii += char.code
        }

        return combinedAscii % storage.size
    }

    fun add(s: String) {
        val hashIndex = hashIndex(s)
        storage[hashIndex].add(HashObject(s))
        println("Added $s to index $hashIndex")
    }

    fun get(s: String): String? {

        val hashIndex = hashIndex(s)

        println("Get $s from $hashIndex")

        return try {
            val compareLinkedList = storage[hashIndex]
            var compareKey = compareLinkedList.first()?.name

            for (i in compareLinkedList.indices) {
                compareKey = compareLinkedList[i]?.name
            }

            compareKey
        } catch (e: Exception) {
            null
        }
    }

    fun display() {
        for (i in storage.indices) {
            if (!storage[i].isEmpty()) {
                storage[i].forEach() { println(it?.name) }
            }
        }
    }
}