class Solution {
    int n;
    public int splitArray(int[] nums, int k){
        n = nums.length;
        Integer[][] dp = new Integer[n][k+1];
        return solve(0,k,nums,dp);
    }
    public int solve(int i,int k,int[] nums,Integer[][] dp){
        if(dp[i][k] != null)return dp[i][k];
        if(k==1){
            int sum = 0;
            for(int t = i; t < n; t++){
                sum += nums[t];
            }
            return sum;
        }
        int res = Integer.MAX_VALUE;
         int currsum = 0;
        for(int j = i; j <= n - k; j++){
            currsum += nums[j];

        int remainingsum = solve(j+1,k-1,nums,dp);
        int largestsum = Math.max(currsum,remainingsum);
        res = Math.min(res,largestsum);
        }
         return dp[i][k] = res;
     }
}