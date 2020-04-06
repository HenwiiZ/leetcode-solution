class Solution {
    public int countPrimes(int n) {
        //从2到n，每次排除掉这个数的倍数，一开始排除4，6， 8……
        //然后3，9，15……
        boolean[] composite = new boolean[n + 1]; 
        int sum = 0;
        for(int i = 2; i < n; i++) {
            if(!composite[i]) {
                sum++;
                for(int j = 1; i * j < n; j++) {
                   composite[i * j] = true; 
                }
            }
        }
        return sum;
    }
}