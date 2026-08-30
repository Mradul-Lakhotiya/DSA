class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();

        while (true) {
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }

            n = sum;

            if (n == 1) {
                return true;
            }

            if (set.contains(n)) {
                return false;
            }

            set.add(sum);
            sum = 0;
        }
    }
}