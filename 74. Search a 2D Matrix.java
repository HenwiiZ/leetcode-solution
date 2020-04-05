class Solution {
    //二分法防止死循环
    //start + 1 < end
    //赋值的时候都是直接等mid，不弄+1-1啥的
    //循环出来的时候肯定有start和end两个index，都检查一遍符合不符合条件
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return false;
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length -1;
        int row = 0;
        while(rowStart + 1 < rowEnd) {
            int rowMid = (rowEnd - rowStart) / 2 + rowStart;
            if(matrix[rowMid][0] == target) return true;
            else if (matrix[rowMid][0] > target) rowEnd = rowMid;
            else rowStart = rowMid;
        }
        if(matrix[rowStart][matrix[0].length - 1] >= target) row = rowStart;
        else if(matrix[rowEnd][matrix[0].length - 1] >= target) row = rowEnd;
        else return false;
        while(colStart + 1 < colEnd) {
            int colMid = (colEnd - colStart) / 2 + colStart;
            if(matrix[row][colMid] == target) return true;
            else if(matrix[row][colMid] > target) colEnd = colMid;
            else colStart = colMid;
        }
        if(matrix[row][colStart] == target || matrix[row][colEnd] == target)
            return true;
        else
            return false;
    }
}