class Solution {
    public int lengthOfLIS(int[] nums) {
        //subarray 一般用双指针，subsequence一般用dp
        //开始的思路：记录如果拿当前element的最大值
        if (nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int globalMax = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] <= nums[j]) {
                    continue;
                }
                max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
            globalMax = Math.max(globalMax, dp[i]);
        }
        return globalMax;
    }
}