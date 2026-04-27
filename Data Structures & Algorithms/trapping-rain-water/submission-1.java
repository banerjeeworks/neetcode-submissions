class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <3) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int area = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                // Process left side
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    area += leftMax - height[left];
                }
                left++;
            } else {
                // Process right side
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    area += rightMax - height[right];
                }
                right--;
            }
        }

        return area;
    }
}

