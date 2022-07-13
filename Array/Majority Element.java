class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i<nums.length; i++){
            if(map.get(nums[i]) != null){
                int temp = map.get(nums[i]);
                if(temp+1 > nums.length/2) return nums[i];
                map.put(nums[i], temp+1);
            }
            else
                map.put(nums[i], 1);
        }
        return 0;
    }
}
