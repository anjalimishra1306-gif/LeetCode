class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        Queue<int[]> q = new LinkedList<>();
         int startR = entrance[0];
         int startC = entrance[1];

        q.offer(new int[]{startR, startC, 0});
        maze[startR][startC] = '+';

        while(!q.isEmpty()){
            int [] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            for (int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n
                && maze[nr][nc] == '.'){
            if (nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1){
                        return dist + 1;
                    }
                    maze[nr][nc] = '+';
                q.offer(new int[]{nr, nc,dist + 1});
                }
            }
        }
        return -1;
    }
}