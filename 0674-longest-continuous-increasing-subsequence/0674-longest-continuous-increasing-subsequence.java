class Solution {
    public int findLengthOfLCIS(int[] nums) {
       int n = nums.length;
        int res = 0;

        for(int i = 0; i < n; i++){
            res = Math.max(res, helper(i, nums));
        }
        return res;
    }
    public int helper(int i, int[] nums){
        int ans = 1;

        if(i + 1 < nums.length && nums[i] < nums[i + 1]){
            ans = Math.max(ans, 1 + helper(i + 1, nums));
        }
        return ans;
    }
}