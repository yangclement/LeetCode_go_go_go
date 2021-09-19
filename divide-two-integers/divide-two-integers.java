class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int half = Integer.MIN_VALUE / 2;
        boolean sign = false;
        if (dividend > 0) {
            sign = !sign;
            dividend = -dividend;
        }
        
        if (divisor > 0) {
            sign = !sign;
            divisor = -divisor;
        }
        int quotient = 0;
        int powerOfTwo = -1;
        
        List<Integer> keys = new ArrayList<Integer>();
        List<Integer> values = new ArrayList<Integer>();
        while (divisor >= dividend) {
            keys.add(divisor);
            values.add(powerOfTwo);
            
            if (divisor < half) {
                break;
            }
            divisor += divisor;
            powerOfTwo += powerOfTwo;
        }
        for (int i = keys.size() - 1; i >= 0; i--) {
            if (keys.get(i) >= dividend) {
                dividend -= keys.get(i);
                quotient += values.get(i);
            }
        }
        
        if (!sign) {
            return -quotient;
        } else {return quotient;}
    }
}