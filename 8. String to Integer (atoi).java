class Solution {
    public int myAtoi(String str) {
        int index = 0;
        boolean positive = true;
        char[] c = str.toCharArray();
        while(index < c.length && c[index] == ' ') index++;
        if(index >= c.length|| 
           !(c[index] == '-' || c[index] == '+' || c[index] - '0' >= 0 && c[index] - '0' <= 9))
            return 0;
        if(c[index] == '-') {
            positive = false;
            index++;
        }
        else if(c[index] == '+') index++;
        int res = 0;
        while(index < c.length && (c[index] - '0' >= 0 && c[index] - '0' <= 9)) {
            if(res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && c[index] - '0' > 7) {
                return positive? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res * 10 + (c[index] - '0');
            index++;
        }
        return positive? res: -res;
    }
}