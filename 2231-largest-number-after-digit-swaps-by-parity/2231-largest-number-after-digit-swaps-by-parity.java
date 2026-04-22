class Solution {
    public int largestInteger(int num) {
        Set<Integer> even = new HashSet<>();

        PriorityQueue<Integer> evenpq = new PriorityQueue<>(
            Collections.reverseOrder()
        );      
        PriorityQueue<Integer> oddpq = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        char[] arr = String.valueOf(num).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i] - '0';

            if (val % 2 == 0) {
                even.add(i);
                evenpq.add(val);
            } 
            else {
                oddpq.add(val);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (even.contains(i)) {
                arr[i] = (char)(evenpq.poll() + '0');
            }
            else {
                arr[i] = (char)(oddpq.poll() + '0');
            }
        }

        return Integer.valueOf(new String(arr));
    }
}