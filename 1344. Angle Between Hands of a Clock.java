class Solution {
    public double angleClock(int hour, int minutes) {
        double mAngle = 0;
        double hAngle = 0;
        if(minutes == 0) mAngle = 0;
        else mAngle = (double) minutes * 6;
        if(hour == 0 || hour == 12) hAngle = 0;
        else {
            hAngle = (double) hour * 30;
        }
        hAngle += (double) minutes / 60 * 30;
        double res = 0;
        res = mAngle >= hAngle? mAngle - hAngle: hAngle - mAngle; 
        return res > 180? 360 - res: res;
    }
}