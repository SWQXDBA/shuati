package 力扣题目.剑指offer

class 从尾到头打印链表 {
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    var li = ListNode(5)
    var l2 = ListNode(6)
    var l3 = ListNode(7)
    li.next = l2
    l2.next = l3
    println(Solution().reversePrint(li).contentToString())
}

class Solution {
    fun reversePrint(head: ListNode?): IntArray {
        var current = head
        val arrayList = ArrayList<Int>()
        while (current != null) {
            arrayList.add(current.`val`)
            current = current.next
        }
        arrayList.reverse()
        return arrayList.toIntArray()
    }
}