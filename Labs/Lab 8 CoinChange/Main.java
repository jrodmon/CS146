import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Test Case 1: " + coinChange(coins1, amount1));

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Test Case 2: " + coinChange(coins2, amount2));
    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coinValue : coins) {
                if (i - coinValue >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coinValue]);
                }
            }
        }

        if (dp[amount] == amount + 1) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
