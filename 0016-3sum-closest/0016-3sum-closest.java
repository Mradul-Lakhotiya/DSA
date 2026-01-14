class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int x = nums[i] + nums[j] + nums[k];
                    int dis;
                    if (x > target) {
                        dis = x - target;
                    }
                    else {
                        dis = target - x;
                    }

                    if (dis < min) {
                        min = dis;
                        res = x;
                    }

                    if (dis == 0) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}