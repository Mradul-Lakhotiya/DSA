class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        double res = 0;

        Arrays.sort(salary);

        for (int i = 1; i < n - 1; i++) {
            res += salary[i];
        }

        return n > 2 ? (res / (n - 2)) : 0;
    }
}