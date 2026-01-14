class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            long minI = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            long maxI = (long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1];

            if (minI > target) {
                break;
            }

            if (maxI < target) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                long minJ = (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                long maxJ = (long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1];

                if (target < minJ) {
                    break;
                }

                if (target > maxJ) {
                    continue;
                }

                int l = j + 1;
                int r = n - 1;
                
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;

                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    }
                    else if (sum < target) {
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }

        return res;
    }
}