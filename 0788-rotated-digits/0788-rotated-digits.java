class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (helper(i)) {
                count++;
            }
        }

        return count;
    }

    boolean helper(int n) {
        boolean flag = false;

        while (n != 0) {
            int dig = n % 10;

            if (dig == 3 || dig == 4 || dig == 7) {
                return false;
            }

            if (dig == 2 || dig == 5 || dig == 6 || dig == 9) {
                flag = true;
            }

            n /= 10;
        }

        return flag;
    }
}