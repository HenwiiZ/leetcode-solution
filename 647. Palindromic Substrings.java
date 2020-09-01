class Solution {
    //假设每一位都是回文字符串的中点，往两边拓展
    //helper(s,i,i)表示长度为奇数的回文字符串
    //helper(s,i,i+1)表示长度为偶数的回文字符串
    public int res = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }
    
    public void helper(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            res++;
            i--;
            j++;
        }
    }
}