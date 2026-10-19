class Solution {

    public static int findFirstIndex(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                result = mid;       
                high = mid - 1;
            } 
            else if (arr[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }
        return result;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        
        Arrays.sort(nums);
        int i = findFirstIndex(nums, target);
        
        if (i == -1) {
            return res;
        }

        while (i < n && nums[i] == target) {
            res.add(i);
            i++;
        }

        return res;
    }
}