class Solution {
    private boolean[] isUsed;
    private int res;
    public int countArrangement(int N) {
        isUsed = new boolean[N + 1];
        res = 0;
        helper(N, 1);
        return res;
    }
    public void helper(int N, int idx) {
        if(idx == N + 1) {
            res++;
            return;
        }
        for(int i = 1; i < N + 1; i++) {
            if(!isUsed[i]) {
                if(i % idx == 0 || idx % i == 0) {
                    isUsed[i] = true;
                    helper(N, idx + 1);
                    isUsed[i] = false;
                }
            }
        }
    }
}