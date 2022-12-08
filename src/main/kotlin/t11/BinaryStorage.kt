package t11

fun main() {
    val binaryStorage = BinaryStorage()

    var inputString: String? = null
    while (inputString?.toInt() !== 0) {

        println(" Press 0 to stop \n Press 1 to add \n Press 2 to search (NUMBER)\n Press 3 to print all")
        inputString = readln()

        when (inputString.toInt()) {
            1 -> {
                binaryStorage.add(readln().toInt())
            }

            2 -> {
                val search = readln().toInt()
                val result = binaryStorage.retrieve(search)
                if (result == null) {
                    println("Number not found")
                } else {
                    println("Found: $result")
                }
            }

            3 -> {
                binaryStorage.display()
            }
        }
    }
}

class BinaryStorage {
    private val storage = ArrayList<Int>()

    fun add(s: Int) {
        if (storage.isEmpty()) {
            storage.add(s)
        } else {
            storage.add(getIndex(0, storage.size - 1, s), s)
        }
    }

    fun retrieve(s: Int): Int? {
        return if (storage.size > 0) {
            search(0, storage.size - 1, s)
        } else {
            null
        }
    }

    private fun getIndex(start: Int, end: Int, number: Int): Int {
        val pivot: Int = start + (end - start) / 2
        val compare: Int = storage[pivot]
        var pivotOffset: Int = 1

        if (pivot + pivotOffset >= storage.size || pivot - pivotOffset < 0) {
            pivotOffset = 0
        }

        return if (number > compare) {
            if (number <= storage[pivot + pivotOffset]) {
                pivot+1
            } else if(pivotOffset == 0) {
                storage.size
            } else {
                getIndex(pivot + pivotOffset, end, number)
            }
        } else if (number < compare) {
            if (number >= storage[pivot - pivotOffset]) {
                pivot
            } else {
                getIndex(start, pivot - pivotOffset, number)
            }
        } else {
            pivot
        }
    }

    private fun search(start: Int, end: Int, s: Int): Int? {
        if (start >= end) {
            println("$start and $end")
            return if (storage[start] == s) {
                storage[start]
            } else {
                return null
            }
        }

        val pivot: Int = start + (end - start) / 2
        val compare: Int = storage[pivot]
        val checkValue: Int = s.compareTo(compare)

        println("checkValue: $checkValue p1: $start p2: $end pivot: $pivot")

        if (checkValue == 0) {
            println("checkValue: $compare")
            return compare
        } else if (checkValue > 0) {
            return search(pivot + 1, end, s)
        } else if (checkValue < 0) {
            return search(start, pivot - 1, s)
        }

        return null
    }

    fun display() {
        storage.forEach { println(it) }
    }
}