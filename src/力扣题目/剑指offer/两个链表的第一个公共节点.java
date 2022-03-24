package 力扣题目.剑指offer;

public class 两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        ListNode longerList;
        ListNode shorterList;
        int longer;
        int shorter;
        if (len1 > len2) {
            longerList = headA;
            shorterList = headB;
            longer = len1;
            shorter = len2;
        } else {
            longerList = headB;
            shorterList = headA;
            longer = len2;
            shorter = len1;
        }
        int step = longer - shorter;
        for (int i = 0; i < step; i++) {
            longerList = longerList.next;
        }
        while (shorterList != longerList && shorterList != null) {
            shorterList = shorterList.next;
            longerList = longerList.next;
        }
        return longerList;

    }

    public int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
