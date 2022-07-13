class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length==0) return -1;
        
        int left = 0;
        int right = nums.length-1;
        
        while(left < right){
            int mid = left + (right - left)/2;
            
            if(nums[mid] > nums[right]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        //left and right are equal after loop,
        int pivot = left;
        left = 0;
        right = nums.length-1;
        
        if(nums[pivot] <= target && target <= nums[right]){
            left = pivot;
        } 
        else{
            right = pivot;
        }
        
        while(left<=right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) return mid;
            
            else if(target < nums[mid]){
                right = mid-1;
            }
            
            else if(nums[mid] < target){
                left = mid+1;
            }
        }
        
        return -1;
    }
}
