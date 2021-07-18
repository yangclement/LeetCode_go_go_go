class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums == null) {
            return -1;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int max = -1;
        while (left < right) {
            int total = nums[left] + nums[right];
            if (total >= k) {
                right--;
            } else {
                max = Math.max(max, total);
                left++;
            }
        }
        return max;
//         if (nums == null) {
//             return -1;
//         }
        
//         Arrays.sort(nums);
        
//         int max = -1;
        
//         for (int i = 0; i < nums.length; i++){
//             if (nums[i] >= k) {
//                 break;
//             }
//             for (int j = i + 1; j < nums.length; j++){
//                 if (nums[i] + nums[j] >= k) {
//                     break;
//                 }
//                 if (nums[i] + nums[j] > max) {
//                     max = nums[i] + nums[j];
//                 }
//             }
//         }
//         return max;
    }
}