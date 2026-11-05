class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    private int atMost(int[] nums, int k){
        int left = 0 ; int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int right = 0; right < nums.length; right++){
           	map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
        while (map.size() > k) {
		   int leftVal = nums[left];
			map.put(leftVal, map.get(leftVal) - 1);

			if (map.get(leftVal) == 0){
					map.remove(leftVal);
				}
				left++;
			}
			count += right - left + 1;
		}
		return count;
    }
}