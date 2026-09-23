class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int ans = 0;
        int[] dp = new int[n];
        for(int i = n-1; i >= 0;i--){
            dp[i] = 1;
        for(int j = i+1; j < n ;j++){
            if(nums[i] < nums[j]){
             dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
         ans = Math.max(ans,dp[i]);
    }
        return ans;
  }
}
