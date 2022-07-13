class Solution {
    public int[] twoSum(int[] nums, int target) {
        int comp = 0;
        ArrayList<Integer> comps = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            comp = target - nums[i];
            if(comps.contains(nums[i])){
                return new int[]{i, comps.indexOf(nums[i])};
            }
            comps.add(comp);
        }
        return null;
    }
}
