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
    String res = "~";
    
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;    
    }

    void dfs(TreeNode node, StringBuilder curr) {
        if (node == null) {
            return;
        }

        curr.append((char)(node.val + 'a'));

        if (node.left == null && node.right == null) {
            String s = new StringBuilder(curr).reverse().toString();
            if (s.compareTo(res) < 0) {
                res = s;
            }
        } 
        else {
            dfs(node.left, curr);
            dfs(node.right, curr);
        }

        curr.deleteCharAt(curr.length() - 1);
    }
}