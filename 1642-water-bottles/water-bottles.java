class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int cnt = 0;
        while (numBottles >= numExchange) {
            int div = numBottles / numExchange;
            cnt += numExchange * div;
            numBottles -= numExchange * div;
            numBottles += div;
        }
        return cnt + numBottles;
    }
}