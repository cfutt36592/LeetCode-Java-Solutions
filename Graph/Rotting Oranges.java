class Solution {
    private final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int numRows = grid.length;
        int numCols = grid[0].length;
        int numFresh = 0;
        for(int r = 0; r<numRows; r++){
            for(int c = 0; c<numCols; c++){
                if(grid[r][c] == 2)
                    queue.add(new int[]{r, c});
                else if(grid[r][c] == 1)
                    numFresh++;
            }
        }
        int time = 0;
        
        while(!queue.isEmpty() && numFresh>0){
            int size = queue.size();
            while(size>0){
                int[] removed = queue.remove();
                for(int[] dir: DIRS){
                    int newX = removed[0] + dir[0];
                    int newY = removed[1] + dir[1];
                    
                    if(newX>=0 && newY>=0 && newX<numRows && newY<numCols && grid[newX][newY]==1){
                        grid[newX][newY] = 2;
                        numFresh--;
                        queue.add(new int[]{newX, newY});
                    }
                }
                size--;
            }
            time++;
        }
        
        return numFresh == 0 ? time : -1;
    }
    
}
