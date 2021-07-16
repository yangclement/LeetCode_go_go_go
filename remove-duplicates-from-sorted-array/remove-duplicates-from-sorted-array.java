class Solution {
    public int removeDuplicates(int[] nums) {
        //[0 0 1 2 2] d = 0, i = 0
        //[0 0 1 2 2] d = 1, i = 1
        //[0 1 1 2 2] d= 1, i = 2 
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