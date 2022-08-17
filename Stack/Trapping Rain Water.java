class Solution {
    //No stack in this solution
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int max = 0;
        for(int i = 0; i < height.length; i++){
            maxLeft[i] = max;
            if(height[i] > max) max = height[i];
        }
        max = 0;
        for(int i = height.length - 1; i >= 0; i--){
            maxRight[i] = max;
            if(height[i] > max) max = height[i];
        }
        int total = 0;
        for(int i = 0; i < height.length; i++){
            int cur = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(cur >= 0) total += cur;
        }
        return total;
    }
}
