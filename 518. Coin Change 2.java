class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for(int j = 1; j <= amount; j++) {
                //dp[i][j]用前i个硬币可以有几种办法能凑成j
                //dp[i][j]等于用前i-1种硬币就凑成了j加上如果用了前i种硬币
                //凑成j-coins[i-1]的次数
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1]? dp[i][j - coins[i - 1]]: 0);
            }
        }
        return dp[coins.length][amount];
    }
}