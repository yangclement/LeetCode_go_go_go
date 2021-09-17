class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currNum = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNum = currNum * 10 + currChar - '0';
            }
            if (!Character.isDigit(currChar) && currChar != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(currNum);
                } else if (sign == '-') {
                    stack.push(-currNum);
                } else if (sign == '*') {
                    stack.push(stack.pop() * currNum);
                } else if (sign == '/') {
                    stack.push(stack.pop() / currNum);
                }
                sign = currChar;
                currNum = 0;
            }
        }
        int res = 0;
        for (int re : stack) {
            res += re;
        }
        return res;
    }
}