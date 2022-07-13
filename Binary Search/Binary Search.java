class Solution {
    public int search(int[] nums, int target) {
        return binary(nums, target, 0, nums.length-1);
    }
    
    public int binary(int[] nums, int target, int left, int right){
        if(right>=left){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) return mid;
            
            else if(target < nums[mid]){
                right = mid-1;
                return binary(nums, target, left, right);
            }
            
            else if(nums[mid] < target){
                left = mid+1;
                return binary(nums, target, left, right);
            }
        }
        return -1;
    }
}
