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
    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root, 1);
        return min;
    }

    private void helper(TreeNode node, int height) {
        if (node.left == null && node.right == null) {
            min = Math.min(min, height);
        }

        if (node.left != null) {
            helper(node.left, height + 1);
        }

        if (node.right != null) {
            helper(node.right, height + 1);
        }
    }
}