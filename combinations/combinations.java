class Solution {
    public List<List<Integer>> combine(int n, int k) {
    //permutation是每个数都要选上，有顺序，所以每次recurrsion都要i = 0开始再看一遍(但跳过visited过的)
    //combination无关顺序，前面已经看过的数字是不需要再看的，所以每次recurrsion都可以从跳过之前看过的index
        List<List<Integer>> results = new ArrayList<>();
        if (n == 0) {
            return results;
        }
        LinkedList<Integer> curr = new LinkedList<Integer>();
        findComb(results, curr, n, k, 1);
        return results;
    }
    
    private void findComb(List<List<Integer>> results, LinkedList<Integer> curr, int n, int k, int startIndex) {
        
        if (curr.size() == k) {
            results.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = startIndex; i <= n; i++) {
            curr.addLast(i);
            //这里pass in的记得是i + 1，不是startIndex + 1;
            findComb(results, curr, n, k, i + 1);
            curr.removeLast();
        }
    }
}