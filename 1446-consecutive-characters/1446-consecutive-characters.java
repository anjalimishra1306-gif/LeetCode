class Solution {
    public int maxPower(String s) {
        int count = 1;
        for(int i = 0; i < s.length();i++){
            count = Math.max(count, helper(i,s));
        }
         return count;
    }
    public int helper(int i , String s){
        int ans = 1;
        int j = i + 1;
        if( j < s.length() && s.charAt(i) == s.charAt(j)){
            ans = Math.max(ans, 1 + helper(j,s));
        }
        return ans;
    }
} 