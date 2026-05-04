class Store {
    Node node;
    int level;

    Store(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Deque<Store> q = new ArrayDeque<>();
        q.offerLast(new Store(root, 0));

        while (!q.isEmpty()) {
            Store curr = q.pollFirst();
            Node node = curr.node;
            int level = curr.level;

            if (res.size() == level) {
                res.add(new ArrayList<>());
            }

            res.get(level).add(node.val);

            if (node.children != null) {
                for (Node child : node.children) {
                    q.offerLast(new Store(child, level + 1));
                }
            }
        }

        return res;
    }
}