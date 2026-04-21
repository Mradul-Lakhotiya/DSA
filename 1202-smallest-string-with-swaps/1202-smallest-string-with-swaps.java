class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);

        for (List<Integer> p : pairs) {
            uf.union(p.get(0), p.get(1));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            map.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        char[] res = new char[n];

        for (List<Integer> group : map.values()) {

            List<Character> chars = new ArrayList<>();
            for (int idx : group) {
                chars.add(s.charAt(idx));
            }

            Collections.sort(group);
            Collections.sort(chars);

            for (int i = 0; i < group.size(); i++) {
                res[group.get(i)] = chars.get(i);
            }
        }

        return new String(res);
    }
}

class UnionFind { 
    private int[] parent; 
    public UnionFind(int n) { 
        parent = new int[n]; 
        
        for (int i = 0; i < n; i++) { 
            parent[i] = i; 
        } 
    } 
    
    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }

        return parent[i];
    }

    public void union(int i, int j) { 
        int repi = find(i); 
        int repj = find(j); 
        
        parent[repi] = repj; 
    }
}