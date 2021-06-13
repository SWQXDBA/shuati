import java.util.*;

 class test {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         while (scanner.hasNext()) {
             String input = scanner.nextLine();
             char[] chars = input.toCharArray();
             List<Character> list = new ArrayList<>();
             for (char c : chars) {
                 if (!list.contains(c)) {
                     list.add(c);
                 }
            }
            for (char c : list) {
                System.out.print(c);
            }
        }

    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode Merge(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null)
                return null;


            Queue<Integer> queue = new LinkedList<>();
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    queue.offer(list1.val);
                    list1 = list1.next;
                } else {
                    queue.offer(list2.val);
                    list2 = list2.next;
                }
            }
            ListNode survivor;
            if (list1 == null)
                survivor = list2;
            else
                survivor = list1;
            while (survivor != null) {
                queue.offer(survivor.val);
                survivor = survivor.next;
            }

            ListNode ret = new ListNode(queue.poll());
            ListNode list = ret;
            while (!queue.isEmpty()) {
                ret.next = new ListNode(queue.poll());
                ret = ret.next;
            }
            return list;

        }

    }
}


