class Solution {
    public int knightDialer(int N) {
        // int[] hor = {-2, -2, 2, 2, -1, -1, 1, 1};
        // int[] ver = {1, -1, 1, -1, 2, -2, 2, -2};
        long[] cur = new long[10];
        int m = 1000000007;
        for(int i = 0; i < 10; i++)
            cur[i] = 1;
        if(N == 0) return 0;
        if(N == 1) return 10;
        for(int i = 2; i <= N; i++) {
            long[] next = new long [10];
            //每次都要取模防止溢出，还得要用long
            next[0] = (cur[4] + cur[6]) % m;
            next[1] = (cur[6] + cur[8]) % m;
            next[2] = (cur[7] + cur[9]) % m;
            next[3] = (cur[4] + cur[8]) % m;
            next[4] = (cur[3] + cur[9] + cur[0]) % m;
            next[5] = 0;
            next[6] = (cur[1] + cur[7] + cur[0]) % m;
            next[7] = (cur[2] + cur[6]) % m;
            next[8] = (cur[1] + cur[3]) % m;
            next[9] = (cur[2] + cur[4]) % m;
            cur = next;
        }
        long res = 0;
        for(int i = 0; i < 10; i++)
            res = (res + cur[i]) % m;
        return (int) res;
    }
}