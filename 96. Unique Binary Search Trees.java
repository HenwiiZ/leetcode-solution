class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //root = 2, 3, 4...
            for (int j = 0; j < i; j++) {
                //number of nodes in the left tree: j
                //number of nodes in the right tree: i - j - 1
                //1 is the number of root node
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}