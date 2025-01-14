class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n + 1];
        int[] C = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (freq[B[i]] == 1) {
                count++;
            }
            else {
                freq[B[i]] = 1;
            }

            if (freq[A[i]] == 1) {
                count++;
            }
            else {
                freq[A[i]] = 1;
            }

            C[i] = count;
        }

        return C;
    }
}