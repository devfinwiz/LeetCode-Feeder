class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if(prices==sorted(prices,reverse=True)):
                return 0
        minprice = prices[0]
        maxprofit = 0
        for price in prices:
            profit = price - minprice
            if profit > maxprofit :
                maxprofit = profit
            if price < minprice:
                minprice = price
        return maxprofit
                    