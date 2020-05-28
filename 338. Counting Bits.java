class Solution {
    //除了1，2，4，8……等只有一个1
    //其它都可以由前面的一个2的幂次方组成
    //12 = 8 + 4，所以就res[12] = res[4]+res[8]
    //至于如何判断是2的幂次呢，只需要一个baseNum记录当前的基础值
    //如果i=baseNum*2，说明又是一次2的幂次方
    public int[] countBits(int num) {
        if(num == 0) return new int[]{0};
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        //
        int baseNum = 1;
        for(int i = 2; i <= num; i++) {
            if(i == baseNum * 2) {
                res[i] = 1;
                baseNum *= 2;
                continue;
            }
            res[i] = res[baseNum] + res[i - baseNum];
        }
        return res;
    }
}

// class Solution {
//     public int[] countBits(int num) {
//         int[] res = new int[num + 1];
//         for(int i = 0; i <= num; i++) {
//             res[i] = Integer.bitCount(i);
//         }
//         return res;
//     }
// }