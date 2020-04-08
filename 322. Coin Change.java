class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            //这里设amount+1是为了判断这个值有没有被更新过
            //amount+1表示没被更新过，证明没办法拼凑出这个值
            dp[i] = amount + 1;
            for(int j = coins.length - 1; j >= 0; j--) {
                if(i < coins[j]) continue;
                dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
            }
        }
        return dp[amount] == amount + 1? -1: dp[amount];
    }
}