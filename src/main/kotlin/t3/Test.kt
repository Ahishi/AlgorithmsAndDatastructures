package t3

fun main(){

    val testTypes = arrayOf("select sort", "quick sort", "merge sort") //How many sorting styles
    val testSet: IntArray = intArrayOf(200, 3000, 10000) //Test set sizes (how many numbers are generated).
    val iterationAmount = 100 //Each test above is run this many times

    val testData = Array(testTypes.size) { Array(testSet.size) { LongArray(iterationAmount) } }

    for((testSetIteration, set) in testSet.withIndex()){

        for (repeatIteration in 0 until iterationAmount){
            val testdata: LongArray = SortAlgorithms.test(set)

            for(deploymentIndex in testTypes.indices){
                testData[deploymentIndex][testSetIteration][repeatIteration] = testdata[deploymentIndex]
            }
        }
    }

    println("\nTest results -------------")
    for((i, type) in testTypes.withIndex()){
        println("$type --------------")
        for((i2, test) in testSet.withIndex()){
            println("In the test of $test numbers and $iterationAmount iterations")
            val observeData: LongArray = testData[i][i2]
            observeData.sort()
            println("fastest was: " + observeData.first()/1000 + "μs")
            println("slowest was: " + observeData.last()/1000 + "μs")
            println("average was: " + observeData.average()/1000 + "μs \n")
        }
    }
}