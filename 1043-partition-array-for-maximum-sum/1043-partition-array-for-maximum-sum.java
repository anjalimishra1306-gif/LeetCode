class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        
        for(int i = n - 1; i>=0;i--){
            int maxNum = -1;
            int len = 0;
            int ans = Integer.MIN_VALUE;

        for(int j = i; j < n && j < i + k;j++){
            maxNum = Math.max(maxNum,arr[j]);
            len = j - i +1;
            int cost = maxNum * len + dp[j+1];
            ans = Math.max(ans,cost);
        }
        dp[i]= ans;
      }
      return dp[0];
    }
}