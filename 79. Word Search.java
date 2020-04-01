class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(helper(board, visited, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    public static boolean helper(char[][] board, boolean[][] visited, String word, int index, int row, int col) {
        if(index >= word.length()) return true;
        if(row < 0 || row >= board.length 
           || col < 0 || col >= board[0].length || visited[row][col] || word.charAt(index) != board[row][col])
            return false;
        visited[row][col] = true;
        boolean exist = helper(board, visited, word, index + 1, row + 1, col) ||
            helper(board, visited, word, index + 1, row - 1, col) ||
            helper(board, visited, word, index + 1, row, col + 1) ||
            helper(board, visited, word, index + 1, row, col - 1);

        //same
//         boolean exist = helper(board, visited, word, index + 1, row + 1, col);
//         if(exist) return true;
//         exist = helper(board, visited, word, index + 1, row - 1, col);
//         if(exist) return true;
//         exist = helper(board, visited, word, index + 1, row, col + 1);
//         if(exist) return true;
//         exist = helper(board, visited, word, index + 1, row, col - 1);
//         if(exist) return true;
        
//         visited[row][col] = false;
//         return false;
        
        if(exist) return true;
        else {
            visited[row][col] = false;
            return false;
        }
    }
}