class Solution {
    public int addDigits(int num) {
        int prev = num;

        while (true) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;   
            }

            num = sum;
            if (num == prev) {
                return num;
            }
            prev = num;
        }
    }
}