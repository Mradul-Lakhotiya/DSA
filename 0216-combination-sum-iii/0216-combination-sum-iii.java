class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        helper(1, k, n, new ArrayList<>());
        return res;    
    }
    
    void helper(int num, int k, int n, List<Integer> curr) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (num > 9 || k == 0 || n < 0) {
            return;
        }
        
        helper(num + 1, k, n, curr);
        
        curr.add(num);
        helper(num + 1, k - 1, n - num, curr);
        curr.remove(curr.size() - 1);
    } 
}