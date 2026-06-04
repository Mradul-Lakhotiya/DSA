class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int i = Math.max(num1, 101); i <= num2; i++) {
            ans += getWaves(makeArray(i));
        }

        return ans;
    }

    int[] makeArray(int number) {
        String s = String.valueOf(number);
        int[] digits = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }

        return digits;
    }

    int getWaves(int[] arr) {
        int res = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] > arr[i] && arr[i + 1] > arr[i]) {
                res++;
            }
            else if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                res++;
            }
        }

        return res;
    }
}