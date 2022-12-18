package t8K

internal class Node (
    var key: String,
    var left: Node? = null,
    var right: Node? = null,
    private var height: Int = 0)
{
    private var nodeHeight: Int = 0

    fun getNodeHeight(): Int {
        return nodeHeight
    }

    fun setNodeHeight(){
        nodeHeight = if(left == null && right === null){
            0
        } else (if(right != null && left != null) {
            if(right?.height!! > left?.height!!){
                right!!.height.plus(1)
            } else {
                left!!.height.plus(1)
            }
        } else if(left == null){
            right!!.height.plus(1)
        } else {
            left!!.height.plus(1)
        })
    }
}