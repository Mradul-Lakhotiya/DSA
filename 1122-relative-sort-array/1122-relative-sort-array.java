class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = arr1.length;

        for (int x : arr1) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int k = 0;
        int[] res = new int[n];

        for (int x : arr2) {
            if (freq.containsKey(x)) {
                int count = freq.get(x);
                while (count-- > 0) {
                    res[k++] = x;
                }
                freq.remove(x);
            }
        }

        List<Integer> remaining = new ArrayList<>();
        for (int key : freq.keySet()) {
            int count = freq.get(key);
            while (count-- > 0) {
                remaining.add(key);
            }
        }

        Collections.sort(remaining);

        for (int x : remaining) {
            res[k++] = x;
        }

        return res;
    }
}