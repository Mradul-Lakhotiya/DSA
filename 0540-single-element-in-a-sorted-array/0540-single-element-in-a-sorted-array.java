class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid  = (h + l) / 2;

            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] != nums[mid + 1]) {
                h = mid;
            }
            else {
                l = mid + 2;
            }
        } 

        return nums[l];
    }
}