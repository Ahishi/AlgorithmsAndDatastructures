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