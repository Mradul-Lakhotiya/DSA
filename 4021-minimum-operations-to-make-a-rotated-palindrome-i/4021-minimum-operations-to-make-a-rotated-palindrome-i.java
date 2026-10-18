class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr1 = s.toCharArray();
        char[] arr2 = new char[n];
        int min = Integer.MAX_VALUE;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                arr2[i] = arr1[(i + k) % n];
            }

            min = Math.min(min, k + cost(arr2));
        }

        return min;
    }

    int cost(char[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int res = 0;

        while (i < j) {
            res += getVal(arr[i], arr[j]);
            i++;
            j--;
        }

        return res;
    }

    int getVal(char a, char b) {
        return  Math.min(Math.abs(a - b), 26 - Math.abs(a - b));
    }    
}