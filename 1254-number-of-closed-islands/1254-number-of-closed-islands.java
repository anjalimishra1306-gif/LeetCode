class Solution {
    int m, n;
    int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int closedIsland(int[][] grid) {
           m = grid.length;
           n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
            
           if ((i == 0 || i == m-1 || j == 0 || j == n-1)
                    && grid[i][j] == 0 && !vis[i][j]){

                    bfs(i, j, grid, vis);
                }
            }
        }
        int count = 0;

        for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){

        if (grid[i][j] == 0 && !vis[i][j]){
             count++;
            bfs(i, j, grid, vis);
            }
        }
    }
    return count;
    }
    public void bfs(int r,int c,int[][] grid,boolean[][] vis){
       Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{r, c});
        vis[r][c] = true;

        while (!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] d : dir){
                int nr = row + d[0];
                int nc = col + d[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n
                    && grid[nr][nc] == 0 && !vis[nr][nc]){

                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
