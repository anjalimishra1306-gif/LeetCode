class Solution {
    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        int n =nums.length;
        int res = 0;
        Integer[] dp = new Integer[n];
        for(int i = 0; i < n;i++){
            res = Math.max(res,helper(i,nums,dp));
        }
       return res;
    }
    public int helper(int i, int[] nums,Integer[] dp){
        if(dp[i]!= null) return dp[i];
        int ans = 1;
        for(int j = i+1; j < nums.length;j++){
            if(nums[i] < nums[j]){
             ans = Math.max(ans,1 + helper(j,nums,dp));
            }
        }
        dp[i] = ans;
        return dp[i];
    }
}
