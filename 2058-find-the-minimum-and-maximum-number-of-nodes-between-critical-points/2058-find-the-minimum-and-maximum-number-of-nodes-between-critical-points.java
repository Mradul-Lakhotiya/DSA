class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        int first = -1;
        int last = -1;
        int min = Integer.MAX_VALUE;

        while (curr.next != null) {
            ListNode next = curr.next;

            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {

                if (first == -1) {
                    first = index;
                } 
                else {
                    min = Math.min(min, index - last);
                }

                last = index;
            }

            prev = curr;
            curr = next;
            index++;
        }

        if (first == last) {
            return new int[]{-1, -1};
        }

        int max = last - first;

        return new int[]{min, max};
    }
}