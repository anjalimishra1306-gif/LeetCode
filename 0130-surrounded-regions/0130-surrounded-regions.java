class Solution {
    public void solve(char[][] board) {
         int m = board.length;
         int n = board[0].length;

        Queue<int[]> q = new LinkedList<>();
         int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){

        if ((i == 0 || i == m-1 || j == 0 || j == n-1)
                && board[i][j] == 'O') {
                    
                 q.offer(new int[]{i, j});
                board[i][j] = '#';
                }
            }
        }
        while (!q.isEmpty()){
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for (int[] d : dir){
                int nr = row + d[0];
                int nc = col + d[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n
                && board[nr][nc] == 'O'){
                q.offer(new int[]{nr, nc});
                 board[nr][nc] = '#';
                }
            }
        }
        for (int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
            if (board[i][j] == 'O'){
                  board[i][j] = 'X';
                }
                else if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        } 
    }
}