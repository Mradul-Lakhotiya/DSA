class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int arr[] = new int[n + m];
        int k = 0, i = 0, j = 0;

        while (i < n && j < m) {
            if (nums1[i] > nums2[j]) {
                arr[k++] = nums2[j++];
            }
            else {
                arr[k++] = nums1[i++];
            }
        }


        while (i < n) {
            arr[k++] = nums1[i++];
        }

        while (j < m) {
            arr[k++] = nums2[j++];
        }

        if (k % 2 != 0) {
            return (double) arr[(int)k / 2];
        }
        else {
            return (double) (arr[(int)(k / 2)] + arr[(int)(k / 2) - 1]) / 2;
        }
    }
}