class Solution {
     public int numDecodings(String s) {
       int n = s.length();
       
       Integer[] dp = new Integer[n];
       return solve(0, s, dp);
    }
     public int solve(int i, String s,Integer[]dp) {
      int n = s.length();
      if (i == n)return 1;
      if (s.charAt(i) == '0')return 0;
      if (dp[i] != null)return dp[i];
      
      int ways = solve(i + 1, s, dp);
      
      if (i + 1 < n){
        int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
      
      if (num >= 10 && num <= 26)
        ways += solve(i + 2, s,dp);
        }

       return dp[i] = ways;
    }
}