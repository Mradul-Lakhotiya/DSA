class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int targetFreq = 0;

            for (int j = i; j < n; j++) {
                int val = nums[j];
                int cnt = map.getOrDefault(val, 0) + 1;
                map.put(val, cnt);

                if (val == target) {
                    targetFreq++;
                }

                int len = j - i + 1;

                if (targetFreq > len / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }
}