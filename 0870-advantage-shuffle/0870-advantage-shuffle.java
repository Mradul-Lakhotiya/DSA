class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums2[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[n];
        int small = 0;
        int large = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int value = arr[i][0];
            int index = arr[i][1];

            if (nums1[large] > value) {
                ans[index] = nums1[large];
                large--;
            } 
            else {
                ans[index] = nums1[small];
                small++;
            }
        }

        return ans;
    }
}