class Solution {
    //burte force. dynamic programming. 记录当前的element是否要加上前一个
    //maximum subarray成为最大subarray
    public int maxSubArray(int[] nums) {
        //second approch，使用prefix sum
        //记录到当前i位置最小的prefix sum，然后用到目前i位置的sum - minnimun subarray sum就是i位置最大的subarray
        int minPrefixSum = 0;
        int Sum = 0;
        int MaxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            Sum += num;
            MaxSum = Math.max(MaxSum, Sum - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, Sum);
            
        }
        return MaxSum;
        
        //first approch, dp
        // if(nums==null || nums.length==0){
        //     return 0;
        // }
        // if(nums.length==1){
        //     return nums[0];
        // }
        // int maxSum = nums[0];
        // int[] dp = new int[nums.length];
        // dp[0] = nums[0];
        // for(int i=1; i<nums.length;i++){
        //     int max;
        //     if(dp[i-1]+nums[i] < nums[i]){
        //         max = nums[i];
        //     }
        //     else{
        //         max = dp[i-1]+nums[i];
        //     }
        //     dp[i] = max;
        //     if(max > maxSum){
        //         maxSum = max;
        //     }
        // }
        // return maxSum;
    }
}