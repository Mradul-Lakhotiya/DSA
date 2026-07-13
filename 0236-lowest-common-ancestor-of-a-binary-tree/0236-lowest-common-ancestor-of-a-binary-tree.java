/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }   

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftR = lowestCommonAncestor(root.left, p, q);
        TreeNode rightR = lowestCommonAncestor(root.right, p, q);

        if (leftR != null && rightR != null) {
            return root;
        }

        return leftR == null ? rightR : leftR;
    }
}