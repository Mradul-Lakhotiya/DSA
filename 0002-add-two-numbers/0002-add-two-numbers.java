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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int num1 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }

            int num2 = 0;
            if  (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            int toAdd = num1 + num2 + carry;

            System.out.println(toAdd + " " + num1 + " " + num2 + " " + carry);

            carry = toAdd / 10;
            toAdd %= 10;

            res.val = toAdd;
            res.next = new ListNode();
            res = res.next;
        }
        
        // return head;
        return removeLast(head);
    }

    private ListNode removeLast(ListNode head) {
        ListNode res = head;
        ListNode temp = head;
        ListNode prev = null;

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;
        return head;
    }
}