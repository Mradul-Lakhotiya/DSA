class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxe) {
        boolean canOpen = true;
        int ans = 0;

        List<Integer> initialBoxes = new ArrayList<>();

        for (int ibox : initialBoxe) {
            initialBoxes.add(ibox);
        }

        while (!initialBoxes.isEmpty() && canOpen) {
            canOpen = false;
            List<Integer> nextBoxes = new ArrayList<>();

            for (int boxId : initialBoxes) {
                if (status[boxId] == 1) {
                    canOpen = true;

                    for (int nb : containedBoxes[boxId]) {
                        nextBoxes.add(nb);
                    }

                    for (int keyId : keys[boxId]) {
                        status[keyId] = 1; 
                    }

                    ans += candies[boxId];
                }
                else {
                    nextBoxes.add(boxId);
                }

                initialBoxes = nextBoxes;
            }
        }
        
        return ans;
    }
}