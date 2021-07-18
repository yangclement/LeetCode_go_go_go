class Solution {
    public int maxFrequency(int[] nums, int k) {
        //如果最大的利用k？
        //在一个array里面，如果我想看看k次操作能让几个数变成nums[j]
        //首先一定要sort这个array，j - 1这个位置是最容易变成j，用的最少的k，其次是 j - 2，因为这个题目只能increase不能decrease，所以不考虑j后面的数字
        //对于每一个nums[j], 用一个sliding windows，一边减少这个k，一边增大sliding windows，直到k消耗为止，每个j都跟新一下这个windows的size
        //valid 的case是: nums[j] * window size - k = sum(j - window size + 1, j)
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int j = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < i && nums[i] * (i - j) - sum > k) {
                sum -= nums[j++];
            }
            max = Math.max(max, i - j + 1);
            //当前的这个数加入window里面进入下一个nums，因为当前nums[i]是最接近下一个数的，也就是nums[i + 1]
            sum += nums[i];
            
        } 
        return max;
    }
}