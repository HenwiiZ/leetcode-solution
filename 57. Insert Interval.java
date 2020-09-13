class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            int[][] temp = new int[1][2];
            temp[0] = newInterval;
            return temp;
        }
        if(newInterval == null) return intervals;
        boolean isUsed = false;
        int i = 0;
        // int j = 0;
        List<int[]> res = new LinkedList<>();
        while(i < intervals.length) {
            while(i < intervals.length && intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
                i++;
            }
            if(i >= intervals.length) break;
            if(intervals[i][0] > newInterval[1]) {
                res.add(newInterval);
                isUsed = true;
                break;
            }
            else {
                isUsed = true;
                int[] temp = new int[2];
                //先定起点
                temp[0] = Math.min(intervals[i][0], newInterval[0]);
                while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
                    i++;
                }
                temp[1] = Math.max(intervals[i - 1][1], newInterval[1]);
                res.add(temp);
                break;
            }
        }
        if(!isUsed) res.add(newInterval);
        while(i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }        
        // while(i < newInterval.length) res.add(newInterval[j]);
        int[][] r = new int[res.size()][2];
        for(int j = 0; j < res.size(); j++) {
            r[j] = res.get(j);
        }
        return r;
    }
}