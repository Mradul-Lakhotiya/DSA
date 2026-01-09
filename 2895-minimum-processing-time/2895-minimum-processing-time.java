class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        List<Integer> time = new ArrayList<>();
        int max;
        int res = 0;
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());

        for (int i = 0; i < processorTime.size(); i++) {
            max = 0;
            for (int k = i * 4; k < (i * 4) + 4; k++) {
                max = Math.max(max, processorTime.get(i) + tasks.get(k));
            }
            res = Math.max(res, max);
        }

        return res;
    }
}