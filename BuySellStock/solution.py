class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        n = len(prices)
        profit = [0]*n

        max_price=prices[n-1]

        for i in range( n-2, 0 ,-1):

            if prices[i]> max_price:
                max_price = prices[i]

            profit[i] = max(profit[i+1], max_price - prices[i])

        min_price=prices[0]

        for i in range(1,n):

            if prices[i] < min_price:
                min_price = prices[i]

            profit[i] = max(profit[i-1], profit[i]+(prices[i]-min_price))

        result = profit[n-1]

        return result
