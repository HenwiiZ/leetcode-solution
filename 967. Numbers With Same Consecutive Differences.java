class Solution {
    private List<Integer> set;
    public int[] numsSameConsecDiff(int N, int K) {
        set = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            helper(i, 1, N, K);
        }
        int[] res = new int[set.size()];
        for(int i = 0; i < set.size(); i++) {
            res[i] = set.get(i);
        }
        return res;
    }
    
    public void helper(int cur, int idx, int N, int K) {
        if(idx >= N) {
            if(String.valueOf(cur).length() == N) set.add(cur);
            return;
        }
        int digit = cur % 10;
        if(digit >= K) {
            helper(cur * 10 + digit - K, idx + 1, N, K);
            if(K == 0) return;
        }
        if(digit < 10 - K) {
            helper(cur * 10 + digit + K, idx + 1, N, K);
        }
        
    }
}