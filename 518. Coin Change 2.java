//How many ways: coins in outer loop
//Least coins: coins in inner loop
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin: coins) {
            for(int j = 0; j <= amount; j++) {
                dp[j] += j >=coin? dp[j - coin]: 0;
            }
        }
        return dp[amount];
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                dp[i][j] += dp[i - 1][j] + (j >= coins[i - 1]? dp[i][j - coins[i - 1]]: 0);                 
            }
        }
        return dp[coins.length][amount];
    }
}