class Solution {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        if (s == " ") {
            return 0;
        }
        int i = 0;
        int sign = 1;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }
        int result = 0;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            //char 如果是数字的话，可以直接和一个char的数字对比 e.g. charAt(i) > '8'
            // char to int, char - '0'
            boolean condition1 = result > Integer.MAX_VALUE / 10;
            boolean condition2 = result == Integer.MAX_VALUE / 10 && s.charAt(i) > '7';
            if (condition1 || condition2){
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            result = result * 10 + s.charAt(i) - '0';
            i++;
        }

        return result * sign;
    }
}