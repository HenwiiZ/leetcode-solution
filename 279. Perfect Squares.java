class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int cur = 1;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            if(i == (cur + 1) * (cur + 1)) {
                dp[i] = 1;
                continue;
            }
            if(i > (cur + 1) * (cur + 1) ) cur++;
            for(int j = cur; j > 0; j--) {
                dp[i] = Math.min(dp[i], dp[j * j] + dp[i - j * j]);
            }
        }
        return dp[n];
    }
}