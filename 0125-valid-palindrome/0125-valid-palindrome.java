class Solution {
    public boolean isPalindrome(String s) {
      int left = 0;
      int right = s.length()-1;
      return helper (s, left,right);  
    }
    
     public boolean isCheck(char ch){
        return (ch >= 48 && ch <= 57) 
            || (ch >= 65 && ch <= 90) 
            || (ch >= 97 && ch <= 122);
    }
    public char convert(char ch) {
        if (ch >= 65 && ch <= 90) {
            return (char) (ch + 32);
        }
        return ch; 
    }

    public boolean helper(String s, int left, int right){
       while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
            
            if(!isCheck(cLeft)){
                left++;
            }else if(!isCheck(cRight)) {
                right--;
            } else{
                char l = convert(cLeft);
                char r = convert(cRight);

                if (l != r)return false;
                left++;
                right--;
            }
        }
        return true;
    } 
}