class Solution {
    public int[] twoSum(int[] nums, int target) {
        //third approch 双指针
        //双指针的前提是要sort好的array
        //这题还不能用双指针，因为返回的是index，一sort完index就乱了
        // Arrays.sort(nums);
        // int start = 0;
        // int end = nums.length - 1;
        // while (start < end) {
        //     int sum = nums[start] + nums[end];
        //     if (sum == target) {
        //         return new int[] {start, end};
        //     } else if (sum > target) {
        //         end--;
        //     } else {
        //         start++;
        //     }
        // }
        // return new int[] {-1, -1};
        //second approch, O(n)
        HashMap<Integer, Integer> exist = new HashMap<Integer, Integer>();
        int[] result= null;
        for (int i=0; i<nums.length;i++){
            int remain = target - nums[i];
            if (exist.containsKey(remain)){
                int index = exist.get(remain);
                result = new int[]{index,i};
                break;
            }
            else {
                exist.put(nums[i],i);
            }
        }
        return result;
        //first approch, O(n^2)
        //sort the array
        // int resultA = 0;
        // int resultB = 0;
        // boolean found = false;
        // for (int i=0; i<nums.length;i++){
        //     int remain = target-nums[i];
        //     for (int j=i+1; j<nums.length; j++){
        //         if(nums[j]==remain){
        //             resultA = i;
        //             resultB = j;
        //             found = true;
        //             break;
        //         }
        //     }
        //     if (found) {
        //         break;
        //     }
        // }
        // return new int[]{resultA, resultB};
    }
}