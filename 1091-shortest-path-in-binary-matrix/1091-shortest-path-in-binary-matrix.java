class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
      int n = grid.length;
      
      boolean [][] vis = new boolean[n][n];
       Queue<int[]> q = new LinkedList<>();

       if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

       int [][] dir = {{-1,-1},{0,1},{0,-1},{1,-1},{-1,0},{1,0},{1,1},{-1,1}};
       q.offer(new int[] {0,0,1});
       vis[0][0] = true;

       while(!q.isEmpty()){
        int[] curr = q.poll();
        int r = curr[0];
        int c = curr[1];
        int d = curr[2];

        if( r == n-1 && c == n-1) return d;

        for(int i = 0; i < 8; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if( nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && !vis[nr][nc]){
                vis[nr][nc] = true;
                q.offer(new int[] { nr, nc, d + 1});
            }
          }
       }
       return -1;
    }
}