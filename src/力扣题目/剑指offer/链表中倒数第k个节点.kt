package 力扣题目.剑指offer

fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
    var right = head;
    var left = head;
    repeat(k - 1) {
        right = right?.next
    }
    while (right?.next != null) {
        right = right?.next
        left = left?.next
    }
    return left
}