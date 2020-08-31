class Solution {
    public boolean isRobotBounded(String instructions) {
        //如果能回到原点，必能形成circle；
        //如果不能回到原点，只能到（x,y）
        //我们可以假设是一个线段从（0，0）到（x，y）
        //只要最后朝向不是N，那必能形成一个正方形
        int[] place = new int[2];
        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int curDir = 0;
        for(int i = 0; i < instructions.length(); i++) {
            if(instructions.charAt(i) == 'G') {
                place[0] += dir[curDir][0];
                place[1] += dir[curDir][1];
            }
            else if(instructions.charAt(i) == 'L') {
                curDir = (curDir + 1) % 4;
            }
            else if(instructions.charAt(i) == 'R') {
                curDir = (curDir - 1 + 4) % 4;
            }
        }
        // System.out.println(place[0] == 0 && place[1] == 0);
        // System.out.println(curDir == 0);
        return (place[0] == 0 && place[1] == 0) || curDir != 0;
    }
}