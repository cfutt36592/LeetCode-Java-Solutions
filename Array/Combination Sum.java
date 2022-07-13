class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return null;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        findCombinations(candidates, 0, target, new ArrayList<>(), result);
        
        return result;
    }
    
    public void findCombinations(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                findCombinations(candidates, i, target-candidates[i], current, result);
                current.remove(new Integer(candidates[i]));
            }
        }
    }
}
