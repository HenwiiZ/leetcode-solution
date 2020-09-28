class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int lastEnd = 0;
        for(int i = 0; i < timeSeries.length; i++) {
            if(lastEnd <= timeSeries[i]) {
                res += duration;
            }
            else {
                if(lastEnd >= timeSeries[i] + duration) ;
                else {
                    res += timeSeries[i] + duration - lastEnd;
                }
            }
            lastEnd = timeSeries[i] + duration;
        }
        return res;
    }
}