class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String l = String.valueOf(low);
        String h = String.valueOf(high);
        int lowLen = l.length();
        int highLen = h.length();
        int len = lowLen;
        List<Integer> res = new LinkedList<>();
        //当位数没超过最大值的位数
        while(len <= highLen) {
            //一开始从最小值的最高位开始
            int startDigit = l.charAt(0) - '0';
            //长度+1之后可以从1开始的
            if(len > lowLen) startDigit = 1;
            //例如四位，最多从10 - 4 = 6开始取
            while(startDigit <= 10 - len) {
                int sum = 0;
                for(int i = 0; i < len; i++) {
                    sum *= 10;
                    sum += (startDigit + i);
                }
                //如果此时已经超出了，后面必超出
                if(sum > high) return res;
                //千万别忘了可能会位数相同但是比最小值要小
                if(sum >= low) res.add(sum);
                startDigit++;
            }
            len++;
        }
        return res;
    }
}