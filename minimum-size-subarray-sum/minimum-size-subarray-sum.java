class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //同向双指针不是太熟悉
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLength = Math.min(minLength, i - start + 1);
                sum -= nums[start++];
            }
        }
        return minLength == Integer.MAX_VALUE? 0 : minLength;
    }
}