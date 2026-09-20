class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
          int len = strs.length;

        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            int zero = 0 , one = 0;

            for (char ch : strs[i - 1].toCharArray()){
                if (ch == '0')
                    zero++;
                else
                    one++;
            }
             for (int j = 0; j <= m; j++){
                for (int k = 0; k <= n; k++){
                    dp[i][j][k] = dp[i - 1][j][k];
                    
                    if (j >= zero && k >= one){
                        dp[i][j][k] = Math.max(dp[i][j][k],1 + dp[i - 1][j - zero][k - one]);
                    }
                }
            }
        }
        return dp[len][m][n];
    }
}