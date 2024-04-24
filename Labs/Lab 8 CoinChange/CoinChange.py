from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount+1] * (amount+1)
        dp[0] = 0

        for i in range(1, amount+1):
            for coinValue in coins:
                if i - coinValue >= 0:
                    dp[i] = min(dp[i], 1 + dp[i - coinValue])

        if dp[i] == amount + 1:
            return -1
        else:
            return dp[amount]
        

if __name__ == "__main__":
    # Input: coins = [1,2,5], amount = 11 
    solution = Solution()
    coins = [1,2,5]
    amount = 11

    print("Test Case 1:", solution.coinChange(coins, amount))

    coins = [2]
    amount = 3 
    print("Test Case 2:", solution.coinChange(coins, amount))
