class Solution {
    
    class Pair{
        int left;
        int right;
        public Pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    public boolean validPalindrome(String s) {
        Pair result;
        result = findDifference(s, 0, s.length() - 1);
        if (result.left >= result.right) {
            return true;
        }
        //pass result as reference, any operation will change the original result[]. Need to create a class
        return lastCheck(s, result.left + 1, result.right) || lastCheck(s, result.left, result.right - 1);
    }
    
    public boolean lastCheck(String s, int i , int j){
        Pair result;
        result = findDifference(s, i, j);
        return result.left >= result.right;
    }
    
    public Pair findDifference(String s, int i, int j){
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
                continue;
            } else {
                return new Pair(i,j);
            }
        }
        return new Pair(i,j);
    }
    
}