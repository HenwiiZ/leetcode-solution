//dp[i][j] 表示从i到j
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        boolean dp[][] = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1)? true: false;
            if(dp[i][i + 1]) {
                start = i;
                end = i + 1;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (s.charAt(j) != s.charAt(j + i)) {
                    dp[j][j + i] = false;
                }
                else {
                    dp[j][j + i] = dp[j + 1][j + i - 1];
                    if (dp[j][j + i]) {
                        start = j;
                        end = j + i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}