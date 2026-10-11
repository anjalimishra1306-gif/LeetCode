class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while( i >= 0 || j >= 0 || carry != 0){
          int ch1 = 0, ch2 = 0;

          if(i >=0) ch1 = num1.charAt(i) -'0';
          if(j >=0) ch2 = num2.charAt(j) -'0';
           int ans = ch1 + ch2 + carry;
           sum.append(ans % 10);
           carry = ans/10;
           i--;
           j--;

        }
        return sum.reverse().toString();
    }
}