class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);

        for (int[] swaps : allowedSwaps) {
            uf.union(swaps[0], swaps[1]);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            map.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int res = 0;

        for (List<Integer> group : map.values()) {

            Map<Integer, Integer> freq = new HashMap<>();

            for (int idx : group) {
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }

            for (int idx : group) {
                int val = target[idx];

                if (freq.getOrDefault(val, 0) > 0) {
                    freq.put(val, freq.get(val) - 1);
                } 
                else {
                    res++;
                }
            }
        }

        return res;
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