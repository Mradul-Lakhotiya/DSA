class Solution {
    public int findKthPositive(int[] arr, int k) {
        int temp = 1;
        int count = 0;

        for (int x : arr) {
            while (x != temp) {
                count++;
                if (count == k) {
                    return temp;
                }
                temp++;
            }

            temp++;
        }

        while (count < k) {
            temp++;
            if (count == k) {
                return temp;
            }
            count++;
        }

        return temp - 1;
    }
}