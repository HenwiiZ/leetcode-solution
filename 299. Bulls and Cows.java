class Solution {
    public String getHint(String secret, String guess) {
        int[] scnt = new int[10];
        int[] gcnt = new int[10];
        int bull = 0;
        for(int i = 0; i < secret.length(); i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);
            if(sc == gc) bull++;
            else {
                scnt[sc - '0']++;
                gcnt[gc - '0']++;
            }
        }
        int cow = 0;
        for(int i = 0; i < 10; i++) {
            cow += Math.min(scnt[i], gcnt[i]);
        }
        StringBuilder res = new StringBuilder();
        res.append(bull);
        res.append("A");
        res.append(cow);
        res.append("B");
        return res.toString();
    }
}