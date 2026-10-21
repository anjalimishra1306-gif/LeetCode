class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
       HashMap<Character,Integer> map = new HashMap<>();

       for(char mg : magazine.toCharArray())
       map.put(mg,map.getOrDefault(mg,0)+1);

        for(char rn : ransomNote.toCharArray()){

            if(!map.containsKey(rn)||map.get(rn)==0)
            return false;

            if(map.containsKey(rn))
             map.put(rn,map.get(rn)-1);  
        }
        return true;
    }
}