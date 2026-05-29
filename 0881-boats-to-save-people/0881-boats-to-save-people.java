class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int boats = 0;
        Arrays.sort(people);

        int i = 0;
        int j = n - 1;

        while(i <= j) {
            if (people[i] + people[j] <= limit) {
                boats++;
                i++;
                j--;
            }
            else {
                boats++;
                j--;
            }
        }

        return boats;
    }
}