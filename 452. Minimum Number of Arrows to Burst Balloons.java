class Solution {
    public int findMinArrowShots(int[][] points) {
        //记住先按照右端点开始排，因为是右边最小决定能扎多少个
        if(points == null || points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
                else return Integer.compare(o1[1], o2[1]);
            }
        });
        
        int res = 1;
        int arrow = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(arrow >= points[i][0]) {
                continue;
            }
            res++;
            arrow = points[i][1];
        }
        return res;
    }
}