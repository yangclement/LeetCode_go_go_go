class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //这是典型的dfs加上需要backtracking的题目，一般要用上dfs加backtrack的都是找所有组合
        //runtime是O(n^(target/min)) -> min是数组的最小值，就是target和min之间有多少个数，就有多少种搭配
        //dfs的话一般用recursion，使用系统的stack就好了
        if (candidates == null) {
            return null;
        }
        //使用linkedlist来记录当前的combination，因为如果backtrack返回上一层的时候，
        //方便把最后一个拿掉.
        //改进：似乎linkedin不方便加到最后result里面，所以还是用arraylist吧
        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        findAllComb(comb, results, target, 0, candidates);
        return results;
    }
    
    private void findAllComb(List<Integer> currComb, 
                             List<List<Integer>> results,
                             int target,
                             int start,
                             int[] candidates
                            ) {
        //已经满足的，把当前combination加到result里面，返回上一层就好
        if (target == 0) {
            List<Integer> clone = new ArrayList<>(currComb);
            results.add(clone);
            return;
        }
        //已经超出target的数了，直接返回不添加
        if (target < 0){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //防止有重复的set在result里面，要跳过相同的已经loop过的element
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            currComb.add(candidates[i]);
            findAllComb(currComb, results, target - candidates[i], i, candidates);
            currComb.remove(currComb.size() - 1);
        }
    }
}