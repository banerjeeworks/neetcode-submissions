class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        //One step beyond the end with a virtual bar of height 0
        for (int i = 0; i <= n; i++) {
            int curHeight = (i == n) ? 0 : heights[i];

            // While current bar is lower than the top of the stack,
            // we can finalize area for the bar at stack top.
            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];

                // Right boundary is 'i - 1'
                int right = i - 1;

                // After popping, top of stack is left smaller bar
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;

                int width = right - left + 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}