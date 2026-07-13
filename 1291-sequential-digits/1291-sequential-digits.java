class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> all = new ArrayList<>();
        int num = 1;
        int numCount = 2;

        while (numCount <= 9) {
            int temp3 = 0;

            for (int i = 0; i < numCount; i++) {
                temp3 = temp3 * 10 + 1;
            }

            while (num % 10 != 9) {
                num += temp3;

                if (num >= low && num <= high) {
                    all.add(num);
                }

                if (num > high) {
                    return all;
                }
            }

            int temp = 1;
            int temp2 = numCount;
            num = 0;
            while (temp2-- > 0) {
                num = num * 10 + temp++;
            }
            numCount++;
        }

        return all;
    }
}