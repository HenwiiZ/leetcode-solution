class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}

// class Solution {
//     public int maxProfit(int[] prices) {
//         int buy = prices[0];
//         int sell = 0;
//         int sum = 0;
//         for(int i = 1; i < prices.length; i++) {
//             if(prices[i] < prices[i - 1]) {
//                 if(sell > buy) {
//                     sum += sell - buy;
//                     if(i == prices.length - 1) return sum;
//                     else {
//                         buy = prices[i];
//                         sell = 0;
//                     }
//                 }
//                 else {
//                     buy = prices[i];
//                 }
//             }
//             else {
//                 if(i == prices.length - 1) {
//                     sum += prices[i] - buy;
//                     return sum;
//                 }
//                 else {
//                     sell = prices[i];
//                 }
//             }
//         }
//         return sum;
//     }
// }