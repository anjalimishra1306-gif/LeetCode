class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int n = nums.length ; int minw = Integer.MAX_VALUE; int sum = 0 ; int left = 0;
       for(int r = 0 ; r < n; r++){
          sum += nums[r];
        while( sum >= target){
             minw = Math.min(minw,r - left + 1);
            sum -= nums[left];
            left++;
         }
       }
       return minw == Integer.MAX_VALUE ? 0 : minw; 
    }
}