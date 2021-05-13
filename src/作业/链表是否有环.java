package 作业;

public class 链表是否有环 {

    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast == slow)
                return true;
            if (fast.next == null)
                return false;
            fast = fast.next;
            if (fast == slow)
                return true;
            if (fast.next == null)
                return false;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
    //一个快 一个慢 快的总能追得上慢的就是说他有环

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
