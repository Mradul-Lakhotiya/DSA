class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int i = 1;
        int k = nums[0] + 1;

        while (k < nums[n - 1]) {
            if (nums[i] != k) {
                res.add(k);
                k++;
            }
            else {
                i++;
                k++;
            }
        }

        return res;
    }
}