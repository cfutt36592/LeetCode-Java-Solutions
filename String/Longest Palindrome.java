class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> sack = new HashMap<>();
        
        for(int i = 0; i<s.length(); i++){
            char key = s.charAt(i);
            if(sack.containsKey(key)){
                sack.put(key, sack.get(key)+1);
            }
            else{
                sack.put(key, 1);
            }
        }
        
        boolean one = false;
        int total = 0;
        for(int count : sack.values()){
            if(count%2 == 0) total+=count;
            else{
                total+=(count-1);
                one = true;
            } 
        }
        if(one) total++;
        return total;
    }
}
