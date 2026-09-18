class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        Set<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                while (set.contains(sum)) {
                    sum++;
                }

                return sum;
            }
            
            sum += nums[i];
        }

        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}