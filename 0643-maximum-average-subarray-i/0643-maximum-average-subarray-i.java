class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int left = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
            double maxAvg = (double)sum/k;

        for(int right = k ; right < nums.length; right++){
            sum += nums[right] - nums[left];
            left++;
            double currAvg = (double) sum / k;
            maxAvg = Math.max(maxAvg,currAvg);
        }
        return maxAvg;
    }
}