class Solution {
    public int search(int[] nums, int key) {
        int pivot = pivotIndex(nums);
        
        if (pivot == -1) {
            return binearySearch(nums, key, 0, nums.length - 1);
        }
        else if (key >= nums[0]) {
            return binearySearch(nums, key, 0, pivot);
        }
        else {
            return binearySearch(nums, key, pivot, nums.length - 1);
        }
    }

    int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                return i+1;
            }
        }
        return -1;
    }

    int binearySearch(int[] nums, int key, int start, int end) {
        int mid = (start + end)/2;

        if (start > end) {
            return -1;
        }

        if (key == nums[mid]) {
            return mid;
        }
        else if (key > nums[mid]) {
            return binearySearch(nums, key, mid + 1, end);
        }
        else {
            return binearySearch(nums, key, start, mid - 1);
        }
    }
}