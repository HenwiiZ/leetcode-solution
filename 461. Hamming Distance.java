class Solution {
    public int hammingDistance(int x, int y) {
        int comb = x ^ y;
        return Integer.bitCount(comb);
    }
}

class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int a = x, b = y;
        while (a != 0 || b != 0) {
            if ((a & 1) != (b & 1)) res ++;
            a = a >> 1;
            b = b >> 1;
        }
        return res;
    }
}