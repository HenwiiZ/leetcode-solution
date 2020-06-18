class Solution {
    //Find Connected Components
    //Start from edge, if it is 'X' continue;
    //If it is 'O', make it "G" and make other "O" connected to it "G"
    //Go through the array
    //'X'->'X', 'O'->'X', 'G'->'O'
    public void solve(char[][] board) {
        if(board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++) {
            flip(board, i, 0);
            flip(board, i, col - 1);
        }
        for(int i = 1; i < col - 1; i++) {
            flip(board, 0, i);
            flip(board, row - 1, i);
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'G') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    public void flip(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length
           || board[i][j] != 'O')
            return;
        board[i][j] = 'G';
        flip(board, i - 1, j);
        flip(board, i + 1, j);
        flip(board, i, j - 1);
        flip(board, i, j + 1);
    }
}