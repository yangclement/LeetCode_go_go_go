class Solution {
    public int lengthOfLIS(int[] nums) {
        //subarray 一般用双指针，subsequence一般用dp
        //开始的思路：记录如果拿当前element的最大值
        //优化：[3,4,1,2,8,5],如果当前数列为这个，有3，4，5和1，2，8 两种可能如果我们打算要继续
        //走这个array的话，必定是选择3，4，5这个组合，因为ending number5比8小，所以他更可以得到最优解，
        //所以我们只需要用dp记录长度与ending number即可 -》 用array index作为长度，值作为ending number
        //for example：i = 0, [0，3] 只有一个长度为3的array （index = 0 的位置记得空出来）
        //              i = 1， [0,3,4], 4 >3 所以可以组成长度为2的subsequence，where ending number is 4
        //              i = 2，[0,1,4], 1与前面3，4都没办法组成subsequence（怎么知道？用binary search），所以element1只能长度为1的sub，且1 < 3，比3 单独组成的length为1的sub好，所以更新3 为1
        //      i = 3, [0,1,2], 用binarysearch找到2可以插入的地方，发现2可以与1组成length为2的sub，且2 < 4, 更新4为2
        //总结来说就是用binary search找到当前element可以插入的地方然后更新后面一位数
        if (nums == null) {
            return 0;
        }
        int[] endingNumber = new int[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            endingNumber[i] = Integer.MAX_VALUE;
        }
        //每一个数字用binray search找到可以replace的位置，用helper
        for (int i = 0; i < nums.length; i++) {
            int index = binarySearch(endingNumber, nums[i]);
            endingNumber[index] = nums[i];
        }
        
        //from the end to the beginning, return a lenth with ending number;
        for (int i = nums.length; i >=1; i--) {
            if (endingNumber[i] != Integer.MAX_VALUE) {
                return i;
            }
        }
        return 0;
        //first approch, runtime O(n^2)
        // int[] dp = new int[nums.length];
        // dp[0] = 1;
        // int globalMax = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     int max = 0;
        //     for (int j = i - 1; j >= 0; j--) {
        //         if (nums[i] <= nums[j]) {
        //             continue;
        //         }
        //         max = Math.max(max, dp[j]);
        //     }
        //     dp[i] = max + 1;
        //     globalMax = Math.max(globalMax, dp[i]);
        // }
        // return globalMax;
    }
    
    //find the first number > num
    private int binarySearch(int[] minLast, int num) {
        int start = 0;
        int end = minLast.length - 1;
        //[0, 3, 4] insert 1 => 
        while (start + 1 < end) {
            int mid = start + ((end - start) / 2);
            if (minLast[mid] == num) {
                return mid;
            } else if (minLast[mid] < num){
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }
}