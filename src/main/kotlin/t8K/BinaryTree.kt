package t8K

internal class BinaryTree {
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
        println(node?.key + " and height: " + node?.getNodeHeight())
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
            val key = node.key
            val comparison = s.compareTo(key)
            println("$comparison and $s ==? $key")
            when {
                comparison < 0 -> {
                    if(node.left != null){
                        println("Going left!")
                        val rNode = replaceValue(s, node.left)
                        if(rNode == null){
                            node.left = null
                        }
                        if(rNode != node.left){
                            node.left = rNode
                        }
                    }
                }
                comparison > 0 -> {
                    if(node.right != null){
                        println("Going right!")
                        val rNode = replaceValue(s, node.right)
                        if(rNode == null){
                            node.right = null
                        }
                        if(rNode != node.right){
                            node.right = rNode
                        }
                    }
                }
                comparison == 0 -> {
                    println("Found: $key")
                    return if(node.right == null && node.left == null){
                        println("Has no children")
                        null
                    } else if(node.right != null && node.left != null) {
                        println("Has both children")
                        println("Searching left-most: Step right")
                        val lmKey = leftMost(node.right!!).key
                        node.key = lmKey
                        println("$key <- $lmKey")
                        node.right = removeLeftMost(node.right!!)
                        node
                    } else {
                        if(node.right != null){
                            println("Has right child")
                            node.right
                        } else {
                            println("Has left child")
                            node.left
                        }
                    }
                }
            }
            return node
        }
        return null
    }

    private fun leftMost(node: Node): Node {
        if(node.left != null){
            println("Searching left-most: Going Left")
            return leftMost(node.left!!)
        }
        println("Leftmost is " + node.key)
        return node
    }

    private fun removeLeftMost(node: Node): Node?{
        if(node.left != null){
            println("Searching removing-left-most: Going Left")
            val returnNode = removeLeftMost(node.left!!)
            if(returnNode == null){
                node.left = null
            }
            return node
        }
        println("Leftmost to delete is " + node.key)
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
                            val retrieval = setValue(s, node.left, false)
                            retrieval.setNodeHeight()
                            return retrieval
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
                            val retrieval = setValue(s, node.right, false)
                            retrieval.setNodeHeight()
                            return retrieval
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
        node.setNodeHeight()
        return node
    }
}