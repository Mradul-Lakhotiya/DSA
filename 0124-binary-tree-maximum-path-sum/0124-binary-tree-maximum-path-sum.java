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
    Map<TreeNode, Integer> map = new HashMap<>();
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ans;
    }

    int getMax(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        int left = Math.max(0, getMax(node.left));
        int right = Math.max(0, getMax(node.right));

        ans = Math.max(ans, left + right + node.val);

        int curr = node.val + Math.max(left, right);

        map.put(node, curr);
        return curr;
    }
}