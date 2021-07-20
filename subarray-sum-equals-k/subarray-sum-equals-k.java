class Solution {
    public int subarraySum(int[] nums, int k) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //这题的sum比较难掌握，包不包括当前点比较tricky，复习时再做
        //解法三：基于解法一，解法一对于每个i都需要看i之前的每个sum[j]的value, 但是可以用hash map记录之前的sum[j]
        //因为hash map的retrieve是O(1), 就可以优化到O(n)
        //去hashmap找sum[i] - k这个key, value是 sum[i] - k出现的次数，就可以知道对于sum[i]为ending的有多少个等于k的subarray
        int count = 0;
        //key是sum，value是出现次数
        Map<Integer, Integer> times = new HashMap<Integer, Integer>();
        times.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            //上个element i - 1的sum 加上当前array，然后去找sum - k
            sum += nums[i];
            int diff = sum - k;
            count += times.getOrDefault(diff, 0);
            //存下到目前i的sum，包括sum到map
            times.put(sum, times.getOrDefault(sum, 0) + 1);
        }
        return count;

        
        
        
        
        
        //解法二：
        //从每个i开始，用sum记录i - end的结果 -> O(n ^ 2);
        
        
        //解法一：做一个到当前i的total sum，也就是sum (0 - i)，
        //当我想找subarray[j,i]是否合适是，只需要sum[i] - sum[j]
        //runtime 是O(n^2);
//         int[] totalSum = new int[nums.length + 1];
//         totalSum[0] = 0;
//         int count = 0;
//         //先fill up这个totalSum array
//         for (int i = 1; i <= nums.length; i++) {
//             //当前位置i是i之前所有数的和，不包括i
//             totalSum[i] = totalSum[i - 1] + nums[i - 1];
//         }
//         for (int i = 0; i <= nums.length; i++) {
//                 for (int j = 0; j < i; j++) {
//                     int subSum = totalSum[i] - totalSum[j];
//                     if (subSum == k) {
//                         count++;
//                     }
//                 }

//             }
//         return count;
        
        //不可以使用two pointer也就是sliding windows
        //因为这个题目会contains负数
        //使用sliding windows的时候我们要确定知道扩大和缩小windows的条件
        //但是在这个题目里面，当k等于2时，[1, 1, 1]是invalid的所以就不再考虑，但是万一[1 , 1, 1, -1]，最后一位是-1， 我们就会miss掉这个情况。
        //所以two pointer要确认当前windows可以决定是否正确的sub 解法去解决最终的问题，但是此题当得到sum > k 的时候是没法确定的，因为后面有可能有负数使得sum减少
        //first approch: 题目理解错了，不是return能sum up成k的subarray里面的elemnt的个数，而是要找出所有可以sum up成k的subarray，然后return 这些subarray的个数
        //首先subarray就是双指针来做
        //这个是求sum是同向双指针，很明显的sliding window
        //当sum小于的时候往里面加，快pointer ++
        //当sum大于的时候往里面减，慢pointer ++
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }
    //     int start = 0;
    //     int end = 0;
    //     int sum = 0;
    //     while (end < nums.length) {
    //         if (sum < k) {
    //             sum += nums[end++];
    //         } else if (sum > k) {
    //             sum -= nums[start++];
    //         } else {
    //             return end - start;
    //         }
    //     }
    //     return 0;
    }
}