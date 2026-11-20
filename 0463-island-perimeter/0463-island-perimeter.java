class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int perimeter = 0;

     for (int r = 0; r < m; r++){
      for (int c = 0; c < n; c++){
        
        if (grid[r][c] == 1) {
            boolean[][] vis = new boolean[m][n];
            Queue<int[]> q = new LinkedList<>();
              q.add(new int[]{r, c});
                vis[r][c] = true;

                while (!q.isEmpty()) {
                  int[] curr = q.poll();
                  int cr = curr[0];
                  int cc = curr[1];

                for (int i = 0; i < 4; i++) {
                    int nr = cr + dr[i];
                    int nc = cc + dc[i];

                if (nr < 0 || 
                   nr >= m ||
                    nc < 0 ||
                   nc >= n || 
                   grid[nr][nc] == 0) {
                    perimeter++;
                } 
                else if (!vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                         }
                        }
                    }
                    return perimeter;
                }
            }
        }
        return 0;
    }
}