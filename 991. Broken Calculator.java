class Solution {
    public int brokenCalc(int X, int Y) {
        if(X >= Y) return X - Y;
        else {
            int res = 0;
            while(X < Y) {
                if(Y % 2 != 0) {
                    Y += 1;
                }
                else {
                    Y /= 2;
                }
                res++;
            }
            return res + X - Y;
        }
    }
}