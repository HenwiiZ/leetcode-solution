class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        //统计K步后还留在棋盘上的个数
        //因为K步后一定有8^K种结果
        int[] hor = {-1, -1, 1, 1, -2, -2, 2, 2};
        int[] ver = {-2, 2, -2, 2, -1, 1, -1, 1};
        double[][] dp = new double[N][N];
        dp[r][c] = 1.0;
        for(int i = 0; i < K; i++) {
            double[][] tmp = new double[N][N];
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    for(int t = 0; t < 8; t++) {
                        if(j + ver[t] > N - 1 || j + ver[t] < 0
                          || k + hor[t] > N - 1 || k + hor[t] < 0)
                            continue;
                        tmp[j + ver[t]][k + hor[t]] += dp[j][k];
                    }
                }
            }
            dp = tmp;
        }
        double res = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                res += dp[i][j];
            }
        }
        res = res / Math.pow(8, K);
        return res;
    }
}