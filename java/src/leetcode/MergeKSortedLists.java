package leetcode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        mergeKLists(new ListNode[]{new ListNode(1), new ListNode(4, new ListNode(5)), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6))});
        mergeKLists(new ListNode[]{new ListNode()});
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if (lists.length == 0) {
            return new ListNode();
        }
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            ListNode now = node;
            if (now != null) {
                while (true) {
                    pq.add(now.val);
                    if (now.next == null) {
                        break;
                    }
                    now = now.next;
                }
            }
        }

        ListNode answer = new ListNode();
        ListNode now = answer;
        while (!pq.isEmpty()) {
            now.val = pq.poll();
            if (pq.isEmpty()) {
                now.next = null;
                break;
            }
            now.next = new ListNode();
            now = now.next;
        }

        System.out.println("answer = " + answer.val);
        return answer;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
