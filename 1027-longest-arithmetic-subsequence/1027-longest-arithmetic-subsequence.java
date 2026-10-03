class Solution {
    public int longestArithSeqLength(int[] nums) {
       int n = nums.length;
        int ans = 1;
        int[][] dp = new int[n][1001];
          for(int i = 0; i< n;i++){
            Arrays.fill(dp[i],1);
          }
        for(int i = 0; i < n;i++){
            for(int j = 0; j < i; j++){
                int diff = nums[i] - nums[j];
                int idx = diff + 500;
                dp[i][idx] = Math.max(dp[i][idx],1 + dp[j][idx]);
                ans = Math.max(ans,dp[i][idx]);
            }
        }
        return ans;
    }
}