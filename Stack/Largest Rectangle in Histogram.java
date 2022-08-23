class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            while (!stack.empty() && (i == n || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int base;
                if (stack.empty())
                    base = i;
                else
                    base = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, base * height);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
