class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        //多加一行，多加一列
        //逆着推
        //只能向右或向下，所以先找出右和下哪个需要的血量更少
        //然后减当前格血量变化，如果是负数，说明当前格加血，那到达当前格最低血量为1
        //如果为正数，那就取此正数为当前格所需最低血量
        if(dungeon == null || dungeon.length == 0) return 0;
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] hp = new int[row + 1][col + 1];
        for(int i = 0; i <= row; i++) {
            Arrays.fill(hp[i], Integer.MAX_VALUE);
        }
        hp[row][col - 1] = 1;
        hp[row - 1][col] = 1;
        for(int i = row - 1; i >= 0; i--) {
            for(int j = col - 1; j >= 0; j--) {
                hp[i][j] = Math.max(1, Math.min(hp[i + 1][j], hp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return hp[0][0];
    }
}