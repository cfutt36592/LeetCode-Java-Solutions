class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<magazine.length(); i++){
            String letter = magazine.substring(i, i+1);
            int count = map.getOrDefault(letter, 0);
            map.put(letter, count+1);
        }
        
        for(int i = 0; i<ransomNote.length(); i++){
            String letter = ransomNote.substring(i, i+1);
            int count = map.getOrDefault(letter, 0);
            if(count < 1) return false;
            map.put(letter, count-1);
        }
        return true;
    }
}
