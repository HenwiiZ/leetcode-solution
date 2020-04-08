class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for(String s: strs) {
            int zeros = 0;
            int ones = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1') ones++;
                else zeros++;
            }
            //递减，确保有足够的0和1去匹配，然后经过多次的优化
            for(int i = m; i >= zeros; i--) {
                for(int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}