class Solution {
        //不是dp。把min set 成正无穷，把max设成0，把这个array走一遍，如果遇到比min小的就变成min，否则就看看当前price - min是不是大于max，是的话改max；
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }
            else if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
}