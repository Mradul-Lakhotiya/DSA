class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int ones = 0;
        int n = bits.length;

        if (bits[n - 1] == 1) {
            return false;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (bits[i] == 0) {
                break;
            }
            else if (bits[i] == 1) {
                ones++;
            }
        }

        if (ones % 2 == 0) {
            return true;
        }

        return false;
    }
}