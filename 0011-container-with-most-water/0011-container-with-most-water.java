class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;

        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
        //     }
        // }
        int rigth = n - 1;
        int left = 0;

        while (left < rigth)  {
            ans = Math.max(ans, Math.min(height[rigth], height[left]) * (rigth - left));

            if (height[rigth] < height[left]) {
                rigth--;
            }
            else {
                left++;
            }
        }

        return ans;
    }
}