class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //permutation和combination的题目都可以使用dfs加上backtrack
        //permutation每个数都要用上，每次都是从0开始枚举
        //combination可以有些不选，所以是从startindex开始枚举，跳过某些数
        if (nums == null) {
            return null;
        }
        
        //这样initialize是不允许的
        // List<List<Integer>> results = new ArrayList<ArrayList<Integer>>();
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        boolean[] visited = new boolean[nums.length];
        findAllResults(results, result, nums, visited);
        return results;
        
    }
    private void findAllResults(List<List<Integer>> results, LinkedList<Integer> curr, int[] nums, boolean[] visited) {
        //use a array to keep track of visited nums
        if (curr.size() == nums.length) {
            results.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            //当前的i，可能在上面的recursion中走过了
            if (visited[i] == true) {
                continue;
            }
            //典型backtrack做法，为了进入recursion所add的状态，出来以后都要remove掉
            visited[i] = true;
            curr.addLast(nums[i]);
            findAllResults(results, curr, nums, visited);
            curr.removeLast();
            visited[i] = false;
        }
    }
}