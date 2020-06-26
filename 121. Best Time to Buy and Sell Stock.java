class Solution {
    public int maxProfit(int[] prices) {
        int minPri = Integer.MAX_VALUE;
        int maxPro = 0;
        for(int i = 0; i < prices.length; i++) {
            minPri = Math.min(minPri, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minPri);
        }
        return maxPro;
    }
}