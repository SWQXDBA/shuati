package 力扣题目.剑指offer

class 反转链表 {
}

fun reverseList(head: ListNode?): ListNode? {
    var node1 = head

    if (node1 == null) {
        return null
    }
    var node2 = node1.next
    if (node2 == null) {
        return head
    }

    var node3 = node2.next
    if (node3 == null) {
        node2.next = node1
        node1.next = null
        return node2
    }
    node1.next = null
    while (node2 != null) {
        node3 = node2.next
        node2.next = node1
        node1 = node2
        node2 = node3
    }
    return node1


}