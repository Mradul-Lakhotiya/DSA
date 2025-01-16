class Solution {
   public int xorAllNums(int[] A, int[] B) {
        int x = 0;
        int y = 0;

        for (int a: A) {
            x ^= a;
        }
    
        for (int b: B) {
            y ^= b;
        }
        
        return (A.length % 2 * y) ^ (B.length % 2 * x);
    }
      
}