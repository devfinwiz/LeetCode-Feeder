class Solution {
public:
    int maxProfit(std::vector<int>& prices) {
        int minPrice = INT_MAX; // Initialize minPrice to maximum possible value
        int maxProfit = 0;
        
        for (int price : prices) {
            minPrice = std::min(minPrice, price); // Update minPrice if current price is lower
            maxProfit = std::max(maxProfit, price - minPrice); // Update maxProfit if selling at current price gives better profit
        }
        
        return maxProfit;
    }
};