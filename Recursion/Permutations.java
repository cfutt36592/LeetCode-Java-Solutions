class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> dt = new ArrayList<>();
        for(int num : nums){
            dt.add(num);
        }
        
        dfs(new ArrayList<>(), dt);
        return ret;
    }
    
    public void dfs(List<Integer> perm, List<Integer> dt){
        if(dt.size() == 0){
            ret.add(perm);
            return;
        }
        for(Integer num : dt){
            List<Integer> tempPerm = new ArrayList<>(perm);
            List<Integer> tempDT = new ArrayList<>(dt);
            
            tempPerm.add(num);
            tempDT.remove(num);
            
            dfs(tempPerm, tempDT);
        }
    }
}
