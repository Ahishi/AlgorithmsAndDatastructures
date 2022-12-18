package t18.t8I

class BinaryTree {
    private var root: Node? = null

    fun insert(num: Int) {
        root = setValue(num, root, true)
    }

    private fun setValue(testValue: Int, node: Node?, set: Boolean): Node {
        if(node != null){
            val key: Int = node.key
            when {
                testValue < key -> {
                    if(node.left != null){
                        if(!set) {
                            return setValue(testValue, node.left, false)
                        }
                        setValue(testValue, node.left, true)
                    } else if(set){
                        node.left = Node(testValue)
                    }
                }
                testValue > key -> {
                    if(node.right != null){
                        if(!set) {
                            return setValue(testValue, node.right, false)
                        }
                        setValue(testValue, node.right, true)
                    } else if(set){
                        node.right = Node(testValue)
                    }
                }
            }
        } else {
            return Node(testValue)
        }
        return node
    }
}