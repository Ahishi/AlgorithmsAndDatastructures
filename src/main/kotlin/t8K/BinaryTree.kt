package t8K

class BinaryTree {
    var root: Node? = null

    fun insert(s: String) {
        root = setValue(s, root, true)
    }

    fun find(s: String) {
        println(setValue(s, root, false).key)
    }

    fun delete(s: String){
        root = replaceValue(s, root)
    }

    fun printTree(){
        traverse(root)
    }

    private fun traverse(node: Node?){
        println(node?.key)
        if(node?.left != null){
            traverse(node.left)
        }
        if(node?.right != null){
            traverse(node.right)
        }
        return
    }

    private fun replaceValue(s: String, node: Node?): Node?{
        if(node != null){
            val comparison = s.compareTo(node.key)
            when {
                comparison < 0 -> {
                    if(node.left != null){
                        println("Going left!")
                        replaceValue(s, node.left)
                    }
                }
                comparison > 0 -> {
                    if(node.right != null){
                        println("Going right!")
                        replaceValue(s, node.right)
                    }
                }
                comparison == 0 -> {
                    println("Delete: " + node.key)
                    if(node.right == null && node.left == null){
                        return null
                    } else if(node.right != null && node.left != null) {
                        node.key = leftMost(node.right!!).key
                        return removeLeftMost(node.right!!)
                    } else {
                        return if(node.right != null){
                            node.right
                        } else {
                            node.left
                        }
                    }
                }
            }
            return node
        }
        return null
    }

    private fun leftMost(node: Node): Node{
        if(node.left != null){
            return leftMost(node.left!!)
        }
        return node
    }

    private fun removeLeftMost(node: Node): Node?{
        if(node.left != null){
            removeLeftMost(node.left!!)
            return node
        }
        return null
    }

    private fun setValue(s: String, node: Node?, set: Boolean): Node {
        if(node != null){
            val comparison = s.compareTo(node.key)
            when {
                comparison < 0 -> {
                    if(node.left != null){
                        println("Going left!")
                        if(!set){
                            return setValue(s, node.left, false)
                        }
                        setValue(s, node.left, true)
                    } else if(set){
                        println("Setting left!")
                        node.left = Node(s)
                    }
                }
                comparison > 0 -> {
                    if(node.right != null){
                        if(!set){
                            return setValue(s, node.left, false)
                        }
                        println("Going right!")
                        setValue(s, node.right, true)
                    } else if(set){
                        println("Setting right!")
                        node.right = Node(s)
                    }
                }
            }
        } else {
            return Node(s)
        }
        return node
    }
}