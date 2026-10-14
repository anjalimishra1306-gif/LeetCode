class Solution {
    Integer[][] dp;
    String p;
    public int palindromePartition(String s, int k){
        p = s;
        dp = new Integer[s.length()][k+1];
      return solve(0,k);  
    }
    
    public int palindrome(int i,int j){
        int change = 0;
        while(i < j){
            if(p.charAt(i) != p.charAt(j)){
                change++;
              }
                i++;
                j--;
           }
            return change;
        }
        public int solve(int i , int k){
            if(k == 1) return palindrome(i,p.length() - 1);
            
            if(dp[i][k] != null) return dp[i][k];
            int ans = Integer.MAX_VALUE;

            for(int j=i; j<=p.length()-k; j++){
                int cost = palindrome(i,j) + solve(j+1,k-1);
                ans = Math.min(cost,ans);
            }
            return dp[i][k] = ans;
        }
    
}