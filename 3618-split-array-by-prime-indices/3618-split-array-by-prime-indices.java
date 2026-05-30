class Solution {
    public long splitArray(int[] nums) {
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (isPrime(i)) {
                res -= nums[i];
            }
            else {
                res += nums[i];
            }
        }

        return Math.abs(res);
    }

    static boolean isPrime(int n) { 
        if (n <= 1) {
            return false;
        } 

        if (n <= 3) {
            return true;
        } 
    
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } 
        
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false; 
            }
        }
        
        return true; 
    }
}