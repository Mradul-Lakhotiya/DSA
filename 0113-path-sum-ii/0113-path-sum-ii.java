class Solution {
    List<List<Integer>> res;
    int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        this.targetSum = targetSum;

        helper(root, 0, new ArrayList<>());

        return res;
    }

    void helper(TreeNode node, int sum, List<Integer> curr) {
        if (node == null) {
            return;
        }

        curr.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null && sum == targetSum) {
            res.add(new ArrayList<>(curr));
        }

        helper(node.left, sum, curr);
        helper(node.right, sum, curr);

        curr.remove(curr.size() - 1);
    }
}