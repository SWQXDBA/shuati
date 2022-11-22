package 力扣题目.剑指offer;

public class 剑指35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
         int getWay(Node A,Node B){
            int cnt=0;
            Node t = A;
            while(t!=B){
                t=t.next;
                cnt++;
            }
            return cnt;
        }

        Node getNode(Node A,int len){
            Node t = A;
            for (int i = 0; i < len; i++) {
                t=t.next;
            }
            return t;
        }
        public Node copyRandomList(Node head) {
             if(head==null)
                 return null;
            Node newList= new Node(head.val);
            Node thead = head;
            Node temp = newList;
            while(thead.next!=null){
                temp.next=new Node(thead.next.val);
                temp=temp.next;
                thead=thead.next;
            }
             thead = head;
             temp = newList;
            while(true){
                if(thead.random==null){
                    temp.random=null;
                }else
                temp.random=getNode(newList,getWay(head,thead.random));
                if(thead.next==null)
                    break;
                thead=thead.next;
                temp=temp.next;
            }

            return newList;
        }
    }
}
