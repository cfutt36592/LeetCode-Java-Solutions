class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList();
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Defining the boundaries of the matrix.
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        // Defining the direction in which the array is to be traversed.
        int dir = 1;

        while (top <= bottom && left <= right) {
            // moving left->right
            if (dir == 1){
                for (int i = left; i <= right; i++) {
                    spiral.add(matrix[top][i]);
                }
                // Since we have traversed the whole first
                // row, move down to the next row.
                top++;
                dir = 2;
            } 
            // moving top->bottom
            else if (dir == 2){     
                for (int i = top; i <= bottom; i++) {
                    spiral.add(matrix[i][right]);
                }
                // Since we have traversed the whole last
                // column, move left to the previous column.
                right--;
                dir = 3;
            } 
            // moving right->left
            else if (dir == 3) {     
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                // Since we have traversed the whole last
                // row, move up to the previous row.
                bottom--;
                dir = 4;
            } 
            // moving bottom->up
            else if (dir == 4) {     
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                // Since we have traversed the whole first
                // col, move right to the next column.
                left++;
                dir = 1;
            }
        }
        return spiral;
    }
}
