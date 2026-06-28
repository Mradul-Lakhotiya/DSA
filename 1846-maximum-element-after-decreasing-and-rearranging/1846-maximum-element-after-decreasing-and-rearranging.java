class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int res = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] >= res + 1) {
                res++;
            } 
        }

        return res;
    }
}