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
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        int n = preorder.length;
        st.push(root);

        for (int i = 1; i < n; i++) {
            TreeNode node = new TreeNode(preorder[i]);

            if (preorder[i] < st.peek().val) {
                st.peek().left = node;
            }
            else {
                TreeNode par = null;

                while (!st.isEmpty() && st.peek().val < preorder[i]) {
                    par = st.pop();
                }

                par.right = node;
            }

            st.push(node);
        }

        return root;
    }
}