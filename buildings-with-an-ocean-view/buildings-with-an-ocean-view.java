class Solution {
    public int[] findBuildings(int[] heights) {
        if (heights == null || heights.length == 0) {
            return heights;
        }
        int rightMax = 0;
        int[] results = new int[0];
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > rightMax) {
                results = Arrays.copyOf(results, results.length + 1);
                results[results.length - 1] = i;
                rightMax = Math.max(heights[i], rightMax);
            }
        }
        Arrays.sort(results);
        return results;
    }
}