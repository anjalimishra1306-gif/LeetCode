class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(i, j, m, n,grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    private int bfs(int row, int col, int rows, int cols,int[][] grid) {

        int[] DR = {-1, 1, 0, 0};
        int[] DC = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        grid[row][col] = 0;
        q.add(new int[]{row, col});
        int area = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + DR[i];
                int nc = c + DC[i];
                if (nr >= 0 
                && nr < rows 
                && nc >= 0 
                && nc < cols
                && grid[nr][nc] == 1){

                    grid[nr][nc] = 0;
                    area++;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return area;
    }
}