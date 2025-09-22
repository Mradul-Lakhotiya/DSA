class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int count = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int freq : map.values()) {
            max = Math.max(max, freq);
        }

        for (int freq : map.values()) {
            if (max == freq) {
                count++;
            }
        }

        return max * count;
    }
}
