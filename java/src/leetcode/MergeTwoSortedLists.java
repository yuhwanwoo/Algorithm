package leetcode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
//        Input: list1 = [1,2,4], list2 = [1,3,4]
//        Output: [1,1,2,3,4,4]
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answer = new ListNode();
        ListNode now = answer;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                now.next = list1;
                list1 = list1.next;
            } else {
                now.next = list2;
                list2 = list2.next;
            }
            now = now.next;
        }

        now.next = list1 == null ? list2 : list1;
        return answer.next;
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