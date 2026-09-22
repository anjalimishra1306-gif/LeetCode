class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[amount + 1][n];
        return helper(amount, coins,n -1,dp);
      
    }
     private int helper(int amount, int[] coins, int i, Integer[][] dp) {
        if (amount == 0)return 1;
        if (i < 0 || amount < 0)return 0;
        if(dp[amount][i] != null) return dp[amount][i];

        int take = helper(amount - coins[i], coins,i,dp);
        int skip = helper(amount, coins, i - 1,dp);

        return dp[amount][i] = take + skip;
    }
}