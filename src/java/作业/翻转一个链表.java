package 作业;

public class 翻转一个链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode fast = head.next;
        ListNode slow = head;
        head.next = null;
        while (fast.next != null) {
            ListNode temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        fast.next = slow;
        return fast;
    }
}
