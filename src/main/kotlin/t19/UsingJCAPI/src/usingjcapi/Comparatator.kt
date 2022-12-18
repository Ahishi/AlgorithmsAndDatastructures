package t19.UsingJCAPI.src.usingjcapi

fun sortByBalance(arr: ArrayList<TrafficCard>): ArrayList<TrafficCard> {
    arr.sortWith(compareByDescending { it.mBalance })
    return arr
}

fun sortBymOwnerName(arr: ArrayList<TrafficCard>): ArrayList<TrafficCard> {
    arr.sortWith(compareByDescending { it.mOwnerName })
    return arr
}

fun sortByCustom(arr: ArrayList<TrafficCard>): ArrayList<TrafficCard> {
    val lengthComparator = Comparator { card1: TrafficCard, card2: TrafficCard -> card1.mOwnerName.compareTo(card2.mOwnerName)}
    arr.sortWith(lengthComparator)
    return arr
}

fun sortByCustom2(arr: ArrayList<TrafficCard>): ArrayList<TrafficCard> {
    val numberComparator = Comparator { card1: TrafficCard, card2: TrafficCard -> card1.mTravellerNumber.compareTo(card2.mTravellerNumber)}
    arr.sortWith(numberComparator)
    return arr
}

fun sortWithStreams(arr: ArrayList<TrafficCard>): ArrayList<TrafficCard> {
    arr
        .stream()
        .filter { it: TrafficCard -> it.mBalance > 0 && it.mBalance < 25 }
        .forEach { e: TrafficCard -> println(e.toString()) }

    return arr
}