/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> arr = new ArrayList<>();

        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }


        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        int i = 1;

        while (next != null) {
            if (prev.val < curr.val && curr.val > next.val) {
                arr.add(i);
            }

            if (prev.val > curr.val && curr.val < next.val) {
                arr.add(i);
            }

            i++;
            prev = prev.next;
            curr = curr.next;
            next = next.next;
        }

        int min = Integer.MAX_VALUE;
        int n = arr.size();

        if (n < 2) {
            return new int[]{-1, -1};
        }

        for (i = 1; i < n; i++) {
            min = Math.min(min, arr.get(i) - arr.get(i - 1));
        }
        
        return new int[]{min, arr.get(n - 1) - arr.get(0)};
    }
}