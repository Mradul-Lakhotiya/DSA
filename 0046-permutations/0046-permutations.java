class Solution {
    int[] nums;
    int n;
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.res = new ArrayList<>();

        boolean[] taken = new boolean[n];
        List<Integer> temp = new ArrayList<>();

        backtrack(temp, taken);

        return res;
    }

    private void backtrack(List<Integer> temp, boolean[] taken) {
        if (temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (taken[i]) {
                continue;
            }

            temp.add(nums[i]);
            taken[i] = true;

            backtrack(temp, taken);

            temp.remove(temp.size() - 1);
            taken[i] = false;
        }
    }
}