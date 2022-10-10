class Solution {
    public int climbStairs(int n) {
        //reverse fibonacci
        int x = 1, y = 0;
        
        for(int i = n - 1; n > 0; n--){
            int temp = x;
            x = x + y;
            y = temp;
        }
        
        return x;
    }
}
