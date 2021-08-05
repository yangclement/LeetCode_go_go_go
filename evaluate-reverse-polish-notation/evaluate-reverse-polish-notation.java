class Solution {
    public int evalRPN(String[] tokens) {
        //保持stack里面最多两个数字，因为题目说了给的token一定valid
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            Boolean isOperator = token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
            if (!isOperator) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int secondNumber = stack.pop();
            int firstNumber = stack.pop();
            int result = 0;
            if (token.equals("+")) {
                result = firstNumber + secondNumber;
            }
            if (token.equals("-")) {
                result = firstNumber - secondNumber;
            }
            if (token.equals("*")) {
                result = firstNumber * secondNumber;
            }
            if (token.equals("/")) {
                result = firstNumber / secondNumber;
            }
            stack.push(result);                                                                                                
        }
        return stack.pop();
    }
}