class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        Integer[][] dp = new Integer[m+1][n+1];
        return helper(m,n,s,p,dp);
    }
    public boolean helper(int i ,int j,String s, String p,Integer[][] dp){
        if( i == 0 && j == 0) return true;
        if( j == 0) return false;
        if( i == 0){
            while( j > 0){
                if(p.charAt(j-1)!= '*'){
                   return false;
                }
                j--;
            }
            return true;
        }
        if(dp[i][j]!= null)return dp[i][j] == 1;
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
            boolean ans = helper(i-1,j-1,s,p,dp);
             dp[i][j] = ans ? 1 : 0;
            return ans;
        }else if(p.charAt(j-1) == '*'){
            boolean ans = helper(i,j-1,s,p,dp) || helper(i-1,j,s,p,dp);
            dp[i][j] = ans ? 1 : 0;
            return ans;
        }else{
            dp[i][j] = 0;
             return false;
        }
    }
}