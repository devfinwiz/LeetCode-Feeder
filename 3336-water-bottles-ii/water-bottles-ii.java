class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int cnt = numBottles;
        for (int i = numBottles; i >= numExchange; numExchange++) {
            cnt++;
            i -= numExchange - 1;
        }
        return cnt;
    }
}