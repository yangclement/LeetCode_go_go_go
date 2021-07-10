class Solution {
    //first approch: this solution does not work. You will generate some duplicates. Need to sort
    //the array first.
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length <= 2) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        // a + b + c = 0 -> a + b = -c;
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // !!!! this could improve the performance
            if (nums[i] > 0) {
                break;
            }
            //使得下面helper不用查重，查contains ！！！！大大加大runtime
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            findTwoSum(i, nums, target, results);
//             if(result.size() != 0) {
//                 result.add(nums[i]);
//                 if (!results.contains(result)) {
//                     results.add(result);
//                 }
                
//             }
        }
        return results;
    }
    
    private void findTwoSum(int index, int[] nums, int target, List<List<Integer>> results) {
        //这里的two sum要使用双指针，因为不仅仅只招一个result
        // HashSet<Integer> visited = new HashSet<Integer>();
        // List<Integer> result = new ArrayList<Integer>();
        int left = index + 1;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                List<Integer> result = new ArrayList<>();
                result.add(nums[left]);
                result.add(nums[right]);
                result.add(-target);
                results.add(result);
                //上面function把c的duplicate去掉了，不需要这一步了
                // if (!results.contains(result)){
                //     results.add(result);    
                // }
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]){
                    left++;
                }
            }
        }
        // for (int i = index + 1; i < nums.length; i++) {
        //     // if (i == index) {
        //     //     continue;
        //     // }
        //     int subTarget = target - nums[i];
        //     if (visited.contains(subTarget)) {
        //         result.add(subTarget);
        //         result.add(nums[i]);
        //         return result;
        //     } else {
        //         visited.add(nums[i]);
        //     }
        // }
        // return result;
    }
}