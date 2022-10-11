package 力扣题目.二叉树

import java.util.LinkedList
import java.util.Stack


class Solution {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        if(root!=null){
            build(root,0,result)
        }


        return result.reversed()
    }
    fun build(root: TreeNode?,currentDeep:Int,result:MutableList<MutableList<Int>>){
        if(root==null){
            return
        }
        build(root.left,currentDeep+1,result)
        build(root.right,currentDeep+1,result)
        while(currentDeep>result.size-1){
            result.add(mutableListOf())
        }
        val ints = result[currentDeep]
        ints.add(root.`val`)
    }
}