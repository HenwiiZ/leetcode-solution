class Solution {
    private int minute;
    private Queue<int[]> q;
    public int orangesRotting(int[][] grid) {
        minute = -1;
        q = new LinkedList<>();
        boolean allzero = true;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    int[] temp = {i, j};
                    q.offer(temp);
                }
                if(grid[i][j] == 1) allzero = false;
            }
        }
        if(q.size() == 0) {
            if(allzero) return 0;
            else return -1;
        }
        while(!q.isEmpty()) {
            int num = q.size();
            for(int i = 0 ; i < num; i++) {
                int[] coord = q.poll();
                int x = coord[0];
                int y = coord[1];
                // int[] temp;
                if(helper(grid, x - 1, y)) {
                    int[] temp = {x - 1, y};
                    q.offer(temp);
                }
                if(helper(grid, x + 1, y)) {
                    int[] temp = {x + 1, y};
                    q.offer(temp);
                }
                if(helper(grid, x, y - 1)) {
                    int[] temp = {x, y - 1};
                    q.offer(temp);
                }
                if(helper(grid, x, y + 1)) {
                    int[] temp = {x, y + 1};
                    q.offer(temp);
                }
            }
            minute++;
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minute;
    }
    public boolean helper(int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
        if(grid[x][y] == 1) {
            grid[x][y] = 2;
            return true;
        }
        return false;
    }
}