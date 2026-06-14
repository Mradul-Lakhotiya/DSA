class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length;
        int ans = Integer.MAX_VALUE;

        for (int k = 0; k < 3; k++) {
            int x = nums2[0] - nums1[k];

            int i = 0;
            int j = 0;
            int rem = 0;

            while (i < n && j < nums2.length) {
                if (nums1[i] + x == nums2[j]) {
                    i++;
                    j++;
                } else {
                    rem++;
                    i++;
                }
            }

            rem += (n - i);

            if (rem <= 2 && j == nums2.length) {
                ans = Math.min(ans, x);
            }
        }

        return ans;
    }
}