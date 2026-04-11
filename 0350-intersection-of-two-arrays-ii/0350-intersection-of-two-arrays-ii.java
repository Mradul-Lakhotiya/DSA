class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq1 = new int[1001];
        int[] freq2 = new int[1001];

        for (int num : nums1) {
            freq1[num]++;
        }

        for (int num : nums2) {
            freq2[num]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < Math.min(freq1[i], freq2[i]); j++) {
                res.add(i);
            }
        }

        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }
}