class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());

        list.sort((a, b) -> {
                if (a.getValue() == b.getValue()) {
                    return b.getKey() - a.getKey();
                }
                else {
                    return a.getValue() - b.getValue();
                }
            }
        );

        int i = 0;
        for (Map.Entry<Integer, Integer> e : list) {
            int val = e.getKey();
            int temp =  e.getValue();

            while (temp-- > 0) {
                nums[i++] = val;
            }
        }

        return nums;
    }
}