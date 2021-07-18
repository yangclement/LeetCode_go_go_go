class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //this question can be done in-plcae or not in-place, in place needs to change the input but with smaller space complexity.
        if (grid == null) {
            return -1;
        }
        if (grid[0][0] != 0) {
            return -1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] distance = new int[grid.length][grid[0].length];
        visited[0][0] = true;
        distance[0][0] = 1;
        final int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1, -1}, {-1, 1}, {-1, -1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int currDistance = distance[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance[row][col];
            }
            for (int[] direction:directions) {
                int currRow = row + direction[0];
                int currCol = col + direction[1];
                if (currRow < 0 || currRow > grid.length - 1 || currCol < 0 || currCol > grid[0].length - 1) {
                    continue;
                }
                if (visited[currRow][currCol]) {
                    continue;
                }

                if (grid[currRow][currCol] != 0) {
                    continue;
                }
                if (currRow == grid.length - 1 && currCol == grid[0].length - 1) {
                    return currDistance + 1;
                }
                visited[currRow][currCol] = true;
                distance[currRow][currCol] = currDistance + 1;
                queue.add(new int[]{currRow, currCol});
            }
        }
        return -1;
    }
}