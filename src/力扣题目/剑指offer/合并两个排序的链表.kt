package 力扣题目.剑指offer

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

    var left = l1
    var right = l2
    var newHead: ListNode? = null
    var newCurrent: ListNode? = null
    while (left != null || right != null) {
        var current: ListNode? = null
        if (left == null) {
            current = right
            right = right?.next
        } else if (right == null) {
            current = left
            left = left.next
        } else if (current == null) {
            if (left.`val` < right.`val`) {
                current = left
                left = left.next
            } else {
                current = right
                right = right.next
            }
        }

        if (newHead == null) {
            newHead = current
            newCurrent = current
        } else {
            newCurrent!!.next = current
            newCurrent = newCurrent.next
        }

    }
    return newHead

}