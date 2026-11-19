class Solution {
    int m; int n;
    public int numIslands(char[][] grid) {
       m = grid.length;
       n = grid[0].length;
       
       boolean[][] vis = new boolean[m][n];
        int component = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1' && !vis[r][c]) {
                    BFS(r, c, grid, vis);
                    component++;
                }
            }
        }
        return component;
    }
    void BFS ( int row , int col,char[][] grid,boolean[][] vis){
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};

      Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        vis[row][col] = true;

        while(!q.isEmpty()){
            int [] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i = 0; i < 4; i++){
                int newR = r + dr[i];
                int newC = c + dc[i];

            if(newR >= 0 && newR < m
             && newC >= 0 && newC < n
             && grid[newR][newC] == '1'
             && !vis[newR][newC]){
                q.add(new int[] {newR,newC});
                vis[newR][newC] = true;
             }
         }
      }
    }
}