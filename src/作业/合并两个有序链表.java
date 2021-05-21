package 作业;

public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head;
        ListNode ret;
        if (l1.val <= l2.val) {
            ret = new ListNode(l1.val);
            head = ret;
            l1 = l1.next;
        } else {
            ret = new ListNode(l2.val);
            head = ret;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ret.next = new ListNode(l1.val);
                ret = ret.next;
                l1 = l1.next;
            } else {
                ret.next = new ListNode(l2.val);
                ret = ret.next;
                l2 = l2.next;
            }
        }
        ret.next = l1 == null ? l2 : l1;
        return head;

    }
}
