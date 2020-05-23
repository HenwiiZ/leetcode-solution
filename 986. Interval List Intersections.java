class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int la = A.length;
        int lb = B.length;
        List<int[]> intervals = new LinkedList<>();
        int ia = 0;
        int ib = 0;
        while(ia < la && ib < lb) {
            int start = A[ia][0] >= B[ib][0]? A[ia][0]: B[ib][0];
            int end = A[ia][1] <= B[ib][1]? A[ia][1]: B[ib][1];
            if(start <= end) {
                int[] temp = {start, end};
                intervals.add(temp);
            }
            if(A[ia][1] >= B[ib][1]) ib++;
            else ia++;
        }
        //
        // int[][] res = new int[intervals.size()][2];
        // for(int i = 0; i < intervals.size(); i++) {
        //     res[i][0] = intervals.get(i)[0];
        //     res[i][1] = intervals.get(i)[1];
        // }
        // return res;
        return intervals.toArray(new int[intervals.size()][]);
    }
}