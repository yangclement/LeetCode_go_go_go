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
        //出来之后还要检查一下，有可能start已经在end右边了
        char first = Character.toLowerCase(s.charAt(start));
        char last = Character.toLowerCase(s.charAt(end));
        return first == last;
    }
}