package 作业;

public class 链表分割 {

    public ListNode partition(ListNode pHead, int x) {
        ListNode head = pHead;
        ListNode smallList = null;
        ListNode smallNodePoint = null;
        ListNode bigList = null;
        ListNode bigNodePoint = null;

        //  把小于x的组装成另一个链表
        while (head != null) {
            if (head.val < x) {
                if (smallList == null) {
                    smallList = new ListNode(head.val);
                    smallNodePoint = smallList;
                } else {
                    smallNodePoint.next = new ListNode(head.val);
                    smallNodePoint = smallNodePoint.next;
                }
            } else {
                if (bigList == null) {
                    bigList = new ListNode(head.val);
                    bigNodePoint = bigList;
                } else {
                    bigNodePoint.next = new ListNode(head.val);
                    bigNodePoint = bigNodePoint.next;
                }
            }
            if (head.next == null)
                break;
            head = head.next;
        }

        if (smallList == null || bigNodePoint == null)
            return pHead;
        smallNodePoint.next = bigList;
        return smallList;
        // write code here
    }

}

