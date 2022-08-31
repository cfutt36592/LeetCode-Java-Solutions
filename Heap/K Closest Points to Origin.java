class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // PriorityQueue<int[]> minHeap = 
            // new PriorityQueue<>(k, (a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        PriorityQueue<int[]> minHeap = 
            new PriorityQueue<>(k, (a, b) -> findDistance(a[0], a[1]) - findDistance(b[0], b[1]));
        
        for(int[] point: points){
            minHeap.add(point);
        }
        
        int[][] ret = new int[k][2]; 
        
        for(int i = 0; i < k; i++){
            ret[i] = minHeap.poll();
        }
        
        return ret;
    }
    
    public int findDistance(int x, int y){
        return (x*x + y*y);
    }
}
