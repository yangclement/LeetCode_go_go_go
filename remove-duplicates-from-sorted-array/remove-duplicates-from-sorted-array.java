class Solution {
    public int removeDuplicates(int[] nums) {
        //一个pointer在后面找不同的数字一个个往前面仍，令一个pointer在前面把一个个扔过来数字按顺序放进去
        //这个array后面可能很乱，但是duplicate左边的数字一定是没有重复的，return dulicate这个位置的index即可
        //因为最后一步duplicate + 1了，所以 duplicate就是length
        //简单而言，快pointer往前面丢unique的数字，慢pointer把fist length of n number变成unique value
        //和sort color的题目很像
        int duplicate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            nums[duplicate] = nums[i];
            duplicate++;
        }
        return duplicate;
    }
}