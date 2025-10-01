class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;

        while (numBottles >= numExchange) {
            int newBottles = numBottles / numExchange;
            int remainder = numBottles % numExchange;   

            sum += newBottles;                         
            numBottles = newBottles + remainder;       
        }

        return sum;
    }
}
