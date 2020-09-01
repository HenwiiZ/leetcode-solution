class Solution {
    public int compress(char[] chars) {
        //三个idx，start和end决定重复字母的起点和终点
        //res更新chars
        if(chars.length == 0 || chars.length == 1) return chars.length;
        int start = 0;
        int end = 0;
        int res = 0;
        while(end < chars.length) {
            end = start + 1;
            while(end < chars.length && chars[start] == chars[end]) {
                end++;
            }
            if(end - start > 1) {
                String cnt = String.valueOf(end - start);
                
                for(int i = 0; i < cnt.length(); i++) {
                    chars[res + i + 1] = cnt.charAt(i);
                }
                res += cnt.length();
            }
            start = end;           
            res++;
            if(start < chars.length) chars[res] = chars[start];
        }
        return res;
    }
}