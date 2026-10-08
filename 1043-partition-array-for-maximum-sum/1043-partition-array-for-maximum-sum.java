class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        Integer[] dp = new Integer[n];
        return solve(0,arr,k,dp);
    }
    public int solve(int i,int[] arr,int k,Integer[] dp){
        if(i >= arr.length)return 0;
        if(dp[i] != null)return dp[i];
        int maxNum = -1;
        int len = 0;
        int ans = Integer.MIN_VALUE;
        for(int j = i; j < arr.length && j < i + k;j++){
            maxNum = Math.max(maxNum,arr[j]);
            len = j - i +1;
            int cost = maxNum * len + solve(j + 1, arr,k,dp);
            ans = Math.max(ans,cost);
        }
        return dp[i] = ans;
    }
}