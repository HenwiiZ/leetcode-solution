class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] squares = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i < 1 || j < 1) {
                    squares[i][j] = matrix[i][j];
                }
                else {
                    if(matrix[i][j] == 0) {
                        squares[i][j] = 0;
                    }
                    else {
                        int temp = Math.min(squares[i - 1][j], squares[i][j - 1]);
                        temp = Math.min(squares[i - 1][j - 1], temp);
                        squares[i][j] = temp + 1;                        
                    }
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                sum += squares[i][j];
            }
        }
        return sum;
    }
}