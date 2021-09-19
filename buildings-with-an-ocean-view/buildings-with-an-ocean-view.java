class Solution {
    public int[] findBuildings(int[] heights) {
        if (heights == null || heights.length == 0) {
            return heights;
        }
        int rightMax = 0;
        List<Integer> temp = new ArrayList<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > rightMax) {
                temp.add(i);
                rightMax = Math.max(heights[i], rightMax);
            }
        }
        int index = 0;
        int[] results = new int[temp.size()];
        for (int i = temp.size() - 1; i >= 0; i--) {
            results[index++] = temp.get(i);
        }
        return results;
    }
}