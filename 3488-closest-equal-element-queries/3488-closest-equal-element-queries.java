class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> indexs = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            indexs.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (ArrayList<Integer> index : indexs.values()) {
            int x = index.get(0);
            int last = index.get(index.size() - 1);
            
            index.add(0, last - n);
            index.add(x + n);
        }

        List<Integer> res = new ArrayList<>();

        for (int q : queries) {
            int x = nums[q];
            ArrayList<Integer> posList = indexs.get(x);

            if (posList.size() == 3) {
                res.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(posList, q);
            
            if (idx < 0) {
                idx = -idx - 1;
            }

            int dist = Math.min(
                posList.get(idx + 1) - posList.get(idx),
                posList.get(idx) - posList.get(idx - 1)
            );
            
            res.add(dist);
        }

        return res;
    }
}