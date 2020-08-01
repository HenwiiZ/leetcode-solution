class Solution {
    public boolean detectCapitalUse(String word) {
        String sup = word.toUpperCase();
        String slow = word.toLowerCase();
        String first = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        if(word.equals(sup) || word.equals(slow) || word.equals(first)) return true;
        else return false;
    }
}