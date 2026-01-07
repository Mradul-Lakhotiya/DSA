/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private long total = 0;
    private long best = 0;
    private final static int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        total = getSum(root);
        dfs(root);
        return (int)(best % MOD);
    }

    private long getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return node.val + getSum(node.left) + getSum(node.right);
    }

    private long dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        long sum = node.val + dfs(node.right) + dfs(node.left);

        best = Math.max(best, sum * (total - sum));

        return sum;
    }
}