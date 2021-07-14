class Solution {
    //这个很重要，可以显示你的coding styl
    public int ROTTEN = 2;
    public int FRESH = 1;
    public int EMPTY = 0;
    public int orangesRotting(int[][] grid) {
        //BFS的题目，但是因为这个有扩散时候的层级要记录，不能用找shortest path的随意扩散直到找到点就行
        //层级要求的bfs可以用single queue，double queue， 和dummmy node queue
        //这里用single queue做就可以了
        if (grid == null) {
            return -1;
        }
        Deque<int[]> queue = new ArrayDeque<int[]>();
        int freshOranges = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        //走遍整个matrix，记录多少个fresh和rotten在哪里
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == FRESH) {
                    freshOranges++;
                }
                if (grid[i][j] == ROTTEN) {
                    queue.add(new int[] {i, j});
                }
                visited[i][j] = false;
            }
        }
        int minutes = 0;
        if (freshOranges == 0) {
            return 0;
        }
        while(!queue.isEmpty()) {
            minutes++;
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                int[] temp = queue.removeFirst();
                int row = temp[0];
                int col = temp[1];
                int fresh = findNeighbors(grid, queue, row, col, visited);
                freshOranges -= fresh;
            }
        }
        if (freshOranges != 0) {
            return -1;
        }
        return minutes - 1;
    }
    
    private int findNeighbors(int[][] grid, Deque<int[]> queue, int row, int col, boolean[][] visited) {
        int freshNeigbors = 0;
        int[][] direction = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < direction.length; i++) {
            int currRow = row + direction[i][0];
            int currCol = col + direction[i][1];
            if (currRow < grid.length && currCol < grid[0].length && currRow >=0 && currCol >= 0 && grid[currRow][currCol] == FRESH && !visited[currRow][currCol]) {
                queue.addLast(new int[]{currRow, currCol});
                freshNeigbors++;
                visited[currRow][currCol] = true;
            }
        }
        return freshNeigbors;
    }
}