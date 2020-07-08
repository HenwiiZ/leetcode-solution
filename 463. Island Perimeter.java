class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)
                    res += count(grid, i, j);
            }
        }
        return res;
    }
    public int count(int[][] grid, int x, int y) {
        int sum = 0;
        if(x == 0) sum++;
        else sum += grid[x - 1][y] == 0? 1: 0;
        if(x == grid.length - 1) sum++;
        else sum += grid[x + 1][y] == 0? 1: 0;
        if(y == 0) sum++;
        else sum += grid[x][y - 1] == 0? 1: 0;
        if(y == grid[0].length - 1) sum++;
        else sum += grid[x][y + 1] == 0? 1: 0;
        return sum;

    }
}