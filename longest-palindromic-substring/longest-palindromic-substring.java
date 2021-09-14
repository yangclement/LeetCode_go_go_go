class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLength = findLength(i, i, s);
            int evenLength = 0;
            if (i != 0) {
                evenLength = findLength(i - 1, i, s);
            }
            
            int currLength = Math.max(oddLength, evenLength);
            if (currLength > end - start) {
                end = i + (currLength / 2);
                start = i - ((currLength - 1) / 2);
            }
        }
        //aa a aa
        return s.substring(start, end);
    }
    
    private int findLength(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left;
    }
}