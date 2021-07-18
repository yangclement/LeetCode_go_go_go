class Solution {
    public int triangleNumber(int[] nums) {
        //the property of the valid combination: a + b > c;
        //similar to three sum
        Arrays.sort(nums);
        int result = 0;
        //两个小边之和要大于第三边c，所以让这个c从大到小for loop
        for (int i = nums.length - 1; i >= 0; i--) {
            result += findGreaterSum(i, nums);
        }
        return result;
    }
    
    private int findGreaterSum(int index, int[] nums) {
        int result = 0;
        int target = nums[index];
        int start = 0;
        int end = index - 1;
        while(start < end) {
            //当相加大于target，说明start 到 end之间的数相加都大于target,然后end--
            if (nums[start] + nums[end] > target) {
                result += end - start;
                end--;
            } else {
                //否则当前start与end相加不够大，不够大的情况和two sum一样，把start加大
                start++;
            }
        }
        return result;
    }
}