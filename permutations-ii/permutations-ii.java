class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        LinkedList<Integer> curr = new LinkedList<Integer>();
        boolean[] visited = new boolean[nums.length];
        findAll(results, curr, nums, visited);
        return results;
    }
    
    private void findAll(List<List<Integer>> results, LinkedList<Integer> curr, int[] nums, boolean[] visited) {
        
        if (curr.size() == nums.length) {
            results.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //基本上和permutation那道题一样，1. 除了前面要sort一下，因为要使得duplicate的number在一起才可以跳过
            //2. 下面这个地方最后面加了 visited[i - 1] == false，是为了在第一层recursion的时候去重
            //当前这个数和前面的数一样，但是前面的数又没visite过，证明此时在recursion最开始的一层，也就是所在pick排序里面的第一个数字，当前数字的排列已经在前面的数字走过了，所以当前的数字可以跳过了
            //这里最后面也可以是visited[i - 1] == true（跟上面刚好相反），但是答案一样的，因为这个做法就不是在第一层recurssion去重，而是在下面去重，上面的那一种比较好理解
            if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) {
                continue;
            }
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            curr.addLast(nums[i]);
            findAll(results, curr, nums, visited);
            visited[i] = false;
            curr.removeLast();
        }
    }
}