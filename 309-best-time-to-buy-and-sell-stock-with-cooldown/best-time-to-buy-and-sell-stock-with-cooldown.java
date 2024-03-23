public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int n = prices.length;

        // Initialize the arrays for buy, sell, and cooldown
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cooldown = new int[n];

        // Base case
        buy[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            // Update the buy array
            buy[i] = Math.max(cooldown[i - 1] - prices[i], buy[i - 1]);

            // Update the sell array
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);

            // Update the cooldown array
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        }

        // The maximum profit is the maximum of sell and cooldown on the last day
        return Math.max(sell[n - 1], cooldown[n - 1]);
    }

    // Example usage:
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices1 = {1, 2, 3, 0, 2};
        System.out.println(solution.maxProfit(prices1));  // Output: 3

        int[] prices2 = {1};
        System.out.println(solution.maxProfit(prices2));  // Output: 0
    }
}
