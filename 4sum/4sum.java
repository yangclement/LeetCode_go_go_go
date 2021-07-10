class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //跟从two sum到3sum的思路一样
        //做two sum然后剩下两个数分别forloop
        //a + b + c + d = target => c + d = target - a - b;
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int newTarget = target - nums[i] - nums[j];
                twoSum(nums, i, j, newTarget, results);
            }
        }
        return results;
    }
    
    private void twoSum(int[] nums, int firstNum, int secondNums, int target, List<List<Integer>> results) {
        int left = secondNums + 1;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                List<Integer> result = new ArrayList<>();
                result.add(nums[firstNum]);
                result.add(nums[secondNums]);
                result.add(nums[left]);
                result.add(nums[right]);
                results.add(result);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
    }
}