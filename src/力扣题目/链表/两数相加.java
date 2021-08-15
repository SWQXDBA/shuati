package 力扣题目.链表;

import 作业.ListNode;

public class 两数相加 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cur = null;
        int addCount = 0;
        while (l1 != null && l2 != null) {
            int x = l1.val + l2.val + addCount;
            if (x >= 10) {
                x %= 10;
                addCount = 1;
            } else {
                addCount = 0;
            }
            if (head == null) {
                head = new ListNode(x);
                cur = head;
            } else {
                cur.next = new ListNode(x);
                cur = cur.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        for (ListNode node = (l1 == null ? l2 : l1); node != null; node = node.next) {
            int x = node.val + addCount;
            if (x >= 10) {
                x %= 10;
                addCount = 1;
            } else {
                addCount = 0;
            }
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        cur.next = addCount == 0 ? null : new ListNode(addCount);

        return head;
    }
}
