package com.github.majdibo.workman.core.utils

class TreeNode<T>(var value: T? = null) : Iterable<TreeNode<T>> {

    var parent: TreeNode<T>? = null

    var children: MutableList<TreeNode<T>> = mutableListOf()


    fun getChild(value: T): TreeNode<T>? {
        if (this.value == value) return this

        children.forEach {
            return if (it.value == value) it else it.getChild(value)
        }

        return null
    }


    fun addChild(node: TreeNode<T>) {
        children.add(node)
        node.parent = this
    }

    fun addChild(node: T) {
        addChild(TreeNode(node))
    }

    override fun iterator(): Iterator<TreeNode<T>> {
        return children.iterator()
    }

    override fun toString(): String {
        var s = "$value"
        if (children.isNotEmpty()) {
            s += "-> " + children.map { it }
        }
        return s
    }
}

fun main() {
    val node1 = TreeNode("1")
    val node2 = TreeNode("2")
    val node3 = TreeNode("3")
    val node4 = TreeNode("4")
    node1.addChild(node3)
    node1.addChild(node2)
    node3.addChild(node4)

    println(node1)

}