package 作业;

public class 链表的回文结构 {
    static ListNode middleNode(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null)
                fast = fast.next;
        }
        return slow;
    }

    static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode fast = head.next;
        ListNode slow = head;
        slow.next = null;
        while (fast.next != null) {
            ListNode temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        fast.next = slow;
        return fast;

    }

    public boolean chkPalindrome(ListNode A) {
        ListNode mieNode = middleNode(A);
        ListNode end = reverseList(mieNode);
        ListNode head = A;
        while (head.val == end.val) {
            if (head.next == end) {
                return true;
            }
            head = head.next;
            end = end.next;
        }
        return false;
    }
}
