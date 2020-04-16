class Solution {
    //dp[i][j]表示以[i][j]为右下角时最大的矩阵边长
    //如果matrix[i][j] = 0, 那就是边长为0
    //否则应该从[i][j-1],[i-1][j]和[i-1][j-1]找最小的，然后+1
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] square = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i - 1 < 0 || j - 1 < 0) {
                    square[i][j] = matrix[i][j] - '0';
                }
                else {
                    if(matrix[i][j] == '0') {
                        square[i][j] = 0;
                    }
                    else {
                        square[i][j] = Math.min(square[i - 1][j], square[i][j - 1]);
                        square[i][j] = Math.min(square[i][j], square[i - 1][j - 1]);
                        square[i][j]++;
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                res = res >= square[i][j]? res: square[i][j];
            }
        }
        return res * res;
    }
}