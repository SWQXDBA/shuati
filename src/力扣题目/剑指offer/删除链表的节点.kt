package 力扣题目.剑指offer

fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
    var cur = head ?: return null;
    if (cur.`val` == `val`) {
        return cur.next
    }
    while (cur.next != null) {
        if (cur.next!!.`val` == `val`) {
            cur.next = cur.next!!.next
            return head
        }
        cur = cur.next!!
    }
    return head
}