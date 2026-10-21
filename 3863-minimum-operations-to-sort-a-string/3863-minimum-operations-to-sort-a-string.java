class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        char[] full = arr.clone();
        Arrays.sort(full);

        if (Arrays.equals(arr, full)) {
            return 0;
        }

        if (n == 2) {
            return -1;
        }
        
        char[] op1 = arr.clone(); Arrays.sort(op1, 0, n - 1);
        char[] op2 = arr.clone(); Arrays.sort(op2, 1, n);
        if (Arrays.equals(op1, full) || Arrays.equals(op2, full)) return 1;

        char minC = full[0], maxC = full[n - 1];
        boolean maxUnique = (full[n-1] != full[n-2]);
        boolean minUnique = (full[0]   != full[1]);

        if (arr[0] == maxC && maxUnique && arr[n-1] == minC && minUnique) return 3;
        return 2;
    }
}