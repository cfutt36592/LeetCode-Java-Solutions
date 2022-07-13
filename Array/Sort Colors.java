class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int i = 0;
        
        while(i<=right){
            if(nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
                left++;
            }
            else if(nums[i] == 2){
                int tmp = nums[i];
                nums[i] = nums[right];
                nums[right] = tmp;
                right--;
                i--;
            }
            i++;
        }
    }
}
