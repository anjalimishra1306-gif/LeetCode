class Solution {
    public int minCut(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n];
        return helper(0, s, dp);
    }
    int helper(int start, String s,Integer[] dp) {
        if (start == s.length())return -1;
        if (dp[start] != null)return dp[start];
        
        int ans = Integer.MAX_VALUE;
        for (int end = start; end < s.length(); end++){
            if (isPalindrome(s, start, end)) {
                ans = Math.min(ans, 1 + helper(end + 1, s, dp));
            }
        }
        return dp[start] = ans;
    }

    boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}