class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
    
    for (int len = 1; len <= n; len++) {
        for (int i = 0; i <= n - len; i++){
            
            int j = i + len - 1;
            
            if (len == 1){
                    palindrome[i][j] = true;
                }
            else if (len == 2) {
                if (s.charAt(i) == s.charAt(j)) {
                    palindrome[i][j] = true;
                }
            }else{
              if (s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1]) {
                    palindrome[i][j] = true;
                    }
                }
            }
        }
         Integer[] dp = new Integer[n];
          return helper(0, s, dp, palindrome);
    }
    int helper(int start, String s, Integer[] dp, boolean[][] palindrome) {
        if (start == s.length())return -1;
        if (dp[start] != null)return dp[start];
        
        int ans = Integer.MAX_VALUE;

        for (int end = start; end < s.length(); end++){
            if (palindrome[start][end]) {
                ans = Math.min(
                    ans,
                    1 + helper(end + 1, s, dp, palindrome)
                );
            }
        }
        return dp[start] = ans;
    }
}

