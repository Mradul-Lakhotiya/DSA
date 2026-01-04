class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;

        for (int n : nums) {
            res += sumIfFourDivisors(n);
        }

        return res;
    }

    private int sumIfFourDivisors(int n) {
        int p = (int)Math.round(Math.cbrt(n));

        if (p * p * p == n && isPrime(p)) {
            return 1 + p + p * p + n;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int j = n / i;

                if (i != j && isPrime(i) && isPrime(j)) {
                    return 1 + i + j + n;
                }

                return 0;
            }
        }

        return 0;
    }

    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
