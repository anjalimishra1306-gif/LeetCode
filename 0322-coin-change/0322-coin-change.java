class Solution {
    public int coinChange(int[] coins, int amount){
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];

         int res = solve(coins,amount,n-1,dp); 
          return (res >= 1e9) ? -1 : res; 
    }
    public int solve(int[] coins, int amount,int i,Integer[][] dp){
        if(amount == 0) return 0;
        if( i < 0) return (int) 1e9;
        if(dp[i][amount] != null) return dp[i][amount];

        int skip = solve(coins,amount,i-1,dp);

        int take = (int) 1e9;
        if(coins[i] <= amount){
            take = 1 + solve(coins, amount - coins[i],i,dp);
           }
          return dp[i][amount] = Math.min(take,skip);
    }
}