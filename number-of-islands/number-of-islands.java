class Solution {
    //starting: use dfs. if encouter 1, go to adjactive 1, until no more 1, go back with stack. change the visited 1 to 0 in case of redundant.
    public int numIslands(char[][] grid){
        int result = 0;
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j]=='0'){
                    continue;
                }else{
                    islandSearch(grid,i,j);
                    result++;
                }
            }
        }
        return result;
    }
    private void islandSearch(char[][] grid, int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        islandSearch(grid, i+1,j);
        islandSearch(grid, i-1,j);
        islandSearch(grid, i,j+1);
        islandSearch(grid, i,j-1);
    }
    //first approch: used while loop for dfs, too complicated, failed, use recursion
//     public int numIslands(char[][] grid) {
//         int result = 0;
//         for(int i = 0; i<grid.length;i++){
//             for(int j = 0; j < grid[i].length;j++){
//                 if(grid[i][j] == '0'){
//                     continue;
//                 }
//                 grid = islandSearch(grid, i, j);
//                 result++;
//             }
//         }
//         return result;
//     }
    
//     private char[][] islandSearch(char[][] grid, int i, int j){
//         //this function is used to dfs
//         Stack<int[]> todo = new Stack<>();
//         char curr;
//         int[] first= new int[]{i,j}
//         todo.push(first);
//         // int previ = -1;
//         // int prevj = -1;
//         int[] visited = new int[2];
//         while(!todo.empty()){
//             int[] coor = todo.peek();
//             int curri = coor[0];
//             int currj = coor[1];
//             curr = grid[curri][currj];
            
//             //看看现在element左边的
//             if(currj!=0 && !(previ == curri && prevj == currj-1)){
//                 if(grid[curri][currj-1]=='1'){
//                     int currCoord[] = new int[]{curri, currj-1};
//                     // currCoord.add(curri);
//                     // currCoord.add(currj - 1);
//                     todo.push(currCoord);
//                     // previ = curri;
//                     // prevj = currj;
//                     continue;
//                 }
//             } // 查看element的上边 
//             if(curri!=0 && !(previ == curri-1 && prevj == currj)){
//                 if(grid[curri-1][currj] == '1'){
//                     int currCoord[] = new int[]{curri-1, currj};
//                     todo.push(currCoord);
//                     // previ = curri;
//                     // prevj = currj;
//                     continue;
//                 }
//             } //查看右边element
//             if(currj != grid[curri].length-1&& !(previ == curri && prevj == currj+1)){
//                 if(grid[curri][currj+1] == '1'){
//                     int currCoord[] = new int[]{curri, currj+1};
//                     todo.push(currCoord);
//                     // previ = curri;
//                     // prevj = currj;
//                     continue;
//                 }
//             }//查看下面element
//             if (curri != grid.length-1&& !(previ == curri+1 && prevj == currj)){
//                 if(grid[curri+1][currj] == '1'){
//                     int currCoord[] = new int[]{curri+1, currj};
//                     todo.push(currCoord);
//                     // previ = curri;
//                     // prevj = currj;
//                     continue;
//                 }
//             }
//             //周围都不是1，那就把当前这个set成0
//             grid[curri][currj] = '0';
//             todo.pop();
//             }
//         return grid;
//     }
}