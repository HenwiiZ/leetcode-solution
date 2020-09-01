class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        //因为一直递减，所以如果出现了小于的情况肯定是不可能的
        if(tx < sx || ty < sy) return false;
        //如果x和y其中一个相等了，另一个就看看终点与起点差值能不能被整除
        if(tx == sx && (ty - sy) % tx == 0) return true;
        if(ty == sy && (tx - sx) % ty == 0) return true;
        //tx和ty肯定有一个比较小，所以取余后还是自己本身
        else return reachingPoints(sx, sy, tx % ty, ty % tx);
    }
}