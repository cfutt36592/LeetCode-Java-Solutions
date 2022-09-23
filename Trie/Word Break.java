class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length()+1];
        arr[s.length()] = true;
        
        for(int i = s.length() - 1; i >= 0; i--){
            for(String word: wordDict){
                if(i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)){
                    arr[i] = arr[i + word.length()];
                }
                if(arr[i]) break;
            }
        }
        
        return arr[0];
    }
}
