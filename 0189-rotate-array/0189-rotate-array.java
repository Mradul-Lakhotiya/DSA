class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;

        k %= n; 

        // for (int i = 0; i < k; i++) {
        //     for (int j = n - 1; j > 0; j--) {
        //         if (j == n - 1) {
        //             sawp(0, n - 1, arr);
        //         }
        //         else {
        //             sawp(j, j + 1, arr);
        //         }
        //     }
        // }

        rotateArray(0, n - 1, arr);
        rotateArray(0, k - 1, arr);
        rotateArray(k, n - 1, arr);
    }

    // private void sawp(int i, int j, int[] arr) {
    //     int temp = arr[i];
    //     arr[i] = arr[j];
    //     arr[j] = temp;
    // }

    private void rotateArray(int i, int j, int[] arr) {
        int temp = 0;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}