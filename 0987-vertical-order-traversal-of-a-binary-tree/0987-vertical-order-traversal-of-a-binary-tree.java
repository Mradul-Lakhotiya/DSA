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

class NodeInfo {
    TreeNode node;
    int row, col;

    NodeInfo(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(new NodeInfo(root, 0, 0));

        while (!q.isEmpty()) {
            NodeInfo curr = q.poll();

            map.computeIfAbsent(curr.col, k -> new TreeMap<>());
            map.get(curr.col)
               .computeIfAbsent(curr.row, k -> new ArrayList<>())
               .add(curr.node.val);

            if (curr.node.left != null) {
                q.offer(new NodeInfo(curr.node.left, curr.row + 1, curr.col - 1));
            }

            if (curr.node.right != null) {
                q.offer(new NodeInfo(curr.node.right, curr.row + 1, curr.col + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, List<Integer>> rows : map.values()) {
            List<Integer> list = new ArrayList<>();

            for (List<Integer> values : rows.values()) {
                Collections.sort(values);
                list.addAll(values);
            }

            ans.add(list);
        }

        return ans;
    }
}