class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if(prices==sorted(prices,reverse=True)):
                return 0
            
        mini=prices[0]
        maxi=0
        prices=prices[1:]
        
        for i in prices:
            profit=i-mini
            maxi=max(profit,maxi)
            if(i<mini):
                mini=i
        
        return maxi
                
                    