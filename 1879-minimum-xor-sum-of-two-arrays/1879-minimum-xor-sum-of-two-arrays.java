class Solution {
    List<Integer> list1;
    List<Integer> list2;
    int[][] dp;

    public int minimumXORSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        int n = nums1.length;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (nums1[i] == nums2[j]) {
                i++;
                j++;
            } 
            else if (nums1[i] < nums2[j]) {
                list1.add(nums1[i]);
                i++;
            } 
            else {
                list2.add(nums2[j]);
                j++;
            }
        }

        while (i < n) {
            list1.add(nums1[i++]);
        }

        while (j < n) {
            list2.add(nums2[j++]);
        }

        int m = list1.size();
        dp = new int[m][1 << m];

        for (int[] x : dp) {
            Arrays.fill(x, -1);   
        }

        return helper(0, 0);
    }

    int helper(int i, int mask) {
        if (i == list1.size()) {
            return 0;
        }

        if (dp[i][mask] != -1) {
            return dp[i][mask];
        }

        int currMin = Integer.MAX_VALUE;

        for (int j = 0; j < list2.size(); j++) {
            if ((mask & (1 << j)) != 0) {
                continue;
            }

            int newMask = mask | (1 << j);
            int val = (list1.get(i) ^ list2.get(j)) + helper(i + 1, newMask);
            
            currMin = Math.min(currMin, val);
        }

        return dp[i][mask] = currMin;
    }
}