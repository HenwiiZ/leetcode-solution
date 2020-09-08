class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // int[][] res = new int[row][col];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
                else {
                    // res[i][j] = Integer.MAX_VALUE;
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int curX = cur[0] + dir[i][0];
                int curY = cur[1] + dir[i][1];
                // if(curX >= 0 && curX < row && curY >= 0 && curY < col 
                //    && res[cur[0]][cur[1]] + 1 < res[curX][curY]) {
                //     res[curX][curY] = res[cur[0]][cur[1]] + 1;
                //     q.offer(new int[]{curX, curY});
                // }
                if(curX >= 0 && curX < row && curY >= 0 && curY < col 
                   && matrix[cur[0]][cur[1]] + 1 < matrix[curX][curY]) {
                    matrix[curX][curY] = matrix[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{curX, curY});
                }                
            }
        }
        return matrix;
        // return res;
    }
}