class Solution {
    public boolean hasMatch(String s, String p) {
       int star = p.indexOf("*");

       String first = p.substring(0,star);
       String second = p.substring(star + 1);

       int index = s.indexOf(first);

       if(index == -1)return false;

        int start = index + first.length();
        int secondIndex = s.indexOf(second, start);

        return secondIndex != -1;
    }
}