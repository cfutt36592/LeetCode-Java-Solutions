class Solution {
    private List<String> ret = new ArrayList<>();
    private String[] table = { "0",   "1",   "abc",  "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
        if(digits.equals(null) || digits.equals("")) return ret;
        
        List<String> dt = new ArrayList<>();
        
        for(int i = 0; i < digits.length(); i++){
            dt.add(digits.substring(i, i+1));
        }
        String temp = "";
        
        dfs(temp, dt);
        
        return ret;
    }
    
    public void dfs(String combo, List<String> dt){
        if(dt.size() == 0){
            ret.add(combo);
            return;
        }
        
        int digit = Integer.parseInt(dt.get(0));
        String letters = table[digit];
        
        for(int i = 0; i < letters.length(); i++){
            List<String> tempDT = new ArrayList<>(dt);
            tempDT.remove(0);
            
            dfs(combo + letters.substring(i, i+1), tempDT);
        }
    }
}
