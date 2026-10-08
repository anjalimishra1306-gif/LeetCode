class Solution {
    public int minCost(int n, int[] cuts) {
      int len = cuts.length;
      int[] arr = new int[len+2];
      Arrays.sort(cuts);
      arr[0] = 0;
      arr[len+1] = n;

      for(int i = 0;i<len;i++){
        arr[i+1] = cuts[i];
      }
      int [][]dp = new int[len+2][len+2];    

       for(int[]row:dp){
          Arrays.fill(row,-1); 
       }
      return solve(0,len+1,arr,dp);
    }
    public int solve(int i, int j, int[] arr,int [][]dp){
        if(i+1 == j)return 0;

         if(dp[i][j]!= -1) 
        return dp[i][j];
       
        int ans = Integer.MAX_VALUE;
       
       for(int k = i+1;k <= j-1;k++){
         int cost = arr[j] - arr[i];
        int left = solve(i,k,arr,dp);
        int right = solve(k,j,arr,dp);
         
         ans = Math.min(ans,cost+left+right);
       }
       return dp[i][j] = ans;
    }
}
