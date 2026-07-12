class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }

        int[][] arrWithIdx = new int[arr.length][2];
        int i = 0;
        
        for (int x : arr) {
            arrWithIdx[i][0] = x;
            arrWithIdx[i][1] = i;
            i++;
        }

        Arrays.sort(arrWithIdx, (a, b) -> a[0] - b[0]);
        
        int prev = arrWithIdx[0][0];
        int rank = 1;

        for (i = 0; i < arr.length; i++) {
            if (prev == arrWithIdx[i][0]) {
                arr[arrWithIdx[i][1]] = rank;
            }
            else {
                rank++;
                arr[arrWithIdx[i][1]] = rank;
                prev = arrWithIdx[i][0];
            }
        }

        return arr;
    }
}