class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            char first = Character.toLowerCase(s.charAt(start));
            char last = Character.toLowerCase(s.charAt(end));
            if (first == last) {
                start++;
                end--;
                continue;
            } else {
                return false;
            }
            
        }
        char first = Character.toLowerCase(s.charAt(start));
        char last = Character.toLowerCase(s.charAt(end));
        return first == last;
    }
}