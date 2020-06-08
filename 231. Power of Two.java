class Solution {
    public boolean isPowerOfTwo(int n) {
        int i = 0;
        while(n > 0) {
            i += 1 & n;
            n = n >> 1;
        }
        return i == 1? true: false;
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        // if (n == 1) return true;
        while (n > 1) {
            int remain = n % 2;
            n /= 2;
            if (remain != 0) return false;
        }
        return true;
    }
}