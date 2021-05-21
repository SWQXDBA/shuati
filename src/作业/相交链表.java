package 作业;

public class 相交链表 {
    static int getLength(ListNode head) {
        int ret = 0;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        while (prev.next != null) {
            prev = prev.next;
            ret++;
        }
        return ret;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode longger = lenA >= lenB ? headA : headB;
        ListNode shortter = longger == headA ? headB : headA;
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            longger = longger.next;
        }
        while (longger != shortter) {
            longger = longger.next;
            shortter = shortter.next;
        }
        return longger;
    }
}
