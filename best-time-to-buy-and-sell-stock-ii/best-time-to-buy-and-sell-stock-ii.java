class Solution {
    //loop这个prices， 把每个增区间的差值加到max里面
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i =1 ;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}