class Solution {
    public int numEnclaves(int[][] grid) {
       int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){

        if ((i == 0 || i == m-1 
           || j == 0 || j == n-1)
            && grid[i][j] == 1) {

            q.offer(new int[]{i, j});
            grid[i][j] = 0;
        }
    }
}
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++){
                int nr = r + d[i][0];
                int nc = c + d[i][1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n
                && grid[nr][nc] == 1){
                    
                q.offer(new int[]{nr, nc});
                  grid[nr][nc] = 0;
                }
            }
        }
        int count = 0;

        for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
            if (grid[i][j] == 1){
                 count++;
                }
            }
        }
        return count;
    }
}