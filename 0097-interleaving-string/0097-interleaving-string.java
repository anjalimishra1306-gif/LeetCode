class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
       int m = s1.length();
       int n = s2.length();
       if( m + n != s3.length())return false;
       Integer [][] dp = new Integer[m+1][n+1];
       return helper(m,n,s1,s2,s3,dp); 
    }
    public boolean helper( int i, int j,String s1, String s2, String s3,Integer [][] dp){
        if( i == 0 && j == 0) return true;
        if(dp[i][j] != null) return dp[i][j] == 1;
         boolean first = false;
         boolean second = false;
         if( i > 0 && s1.charAt(i-1) == s3.charAt(i + j - 1)){
            first = helper(i-1,j,s1,s2,s3,dp);
         }
         if(j > 0 && s2.charAt(j-1) == s3.charAt(i + j - 1)){
            second = helper(i,j-1,s1,s2,s3,dp);
         }
          dp[i][j] = (first || second) ? 1 : 0;
          return first || second;
    }
}