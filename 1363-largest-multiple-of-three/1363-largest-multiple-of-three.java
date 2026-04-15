class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] m1 = new int[] {1, 4, 7, 2, 5, 8};
        int[] m2 = new int[] {2, 5, 8, 1, 4, 7};
        
        int sum = 0;
        int[] freq = new int[10];

        for (int d : digits) {
            freq[d]++;
            sum += d;
        }

        while (sum % 3 != 0) {
            for (int i : sum % 3 == 1 ? m1 : m2) {
                if (freq[i] > 0) {
                    freq[i]--;
                    sum -= i;
                    break;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 9; i >= 0; --i) {
            res.append(Character.toString('0' + i).repeat(freq[i]));
        }
        
        return res.length() > 0 && res.charAt(0) == '0' ? "0" : res.toString();
    }
}