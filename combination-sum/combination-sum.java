class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null) {
            return results;
        }
        
        LinkedList<Integer> result = new LinkedList<>();
        findComb(results, result, candidates, target, 0);
        return results;
    }
    
    private void findComb(List<List<Integer>> results, 
                          LinkedList<Integer> result, 
                          int[] candidates, 
                          int target,
                         int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> temp = new ArrayList<Integer>(result);
            results.add(temp);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            result.addLast(candidates[i]);
            findComb(results, result, candidates, target - candidates[i], i);
            result.removeLast();
        }
    }
}