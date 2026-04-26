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
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left == null) {
            res.add(node.val);
            if (node.right != null) {
                helper(node.right);
            }
        }
        else if (node.left != null) {
            helper(node.left);
            res.add(node.val);
            if (node.right != null) {
                helper(node.right);
            }
        }
    }
}