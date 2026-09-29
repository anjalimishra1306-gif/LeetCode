class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      int n = nums.length;
     int[] dp = new int[n];
     int[] parent = new int[n];
     Arrays.fill(parent,-1);
     Arrays.sort(nums);
     
     int maxLen = 0;
     int startIndex = 0;
     
     for(int i = n-1; i >= 0; i--){
         dp[i] = 1;
         for(int j = i+1; j < n;j++){
            if(nums[j] % nums[i] == 0 && dp[i] < 1 + dp[j]){
                dp[i] = 1 + dp[j];
                parent[i] = j;
            }
            if(maxLen <= dp[i]){
                maxLen = dp[i];
                startIndex = i;
            }
         }
     }
     ArrayList<Integer> ans = new ArrayList<>();
     while(startIndex != -1){
         ans.add(nums[startIndex]);
         startIndex = parent[startIndex];
     }
     return ans;  
    }
}