class Solution {
    private List<List<Integer>> subsets = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> dt = new ArrayList<>();
        for(int num : nums){
            dt.add(num);
        }
        
        dfs(new ArrayList<>(), 0, nums);
        return subsets;
    }
    
    public void dfs(List<Integer> set, int index, int[] nums){
        subsets.add(new ArrayList<>(set));
        
        for(int i = index; i<nums.length; i++){            
            List<Integer> tempSet = new ArrayList<>(set);
            tempSet.add(nums[i]);
            
            dfs(tempSet, i+1, nums);
        }
    }
}
