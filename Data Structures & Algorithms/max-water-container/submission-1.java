class Solution {
    public int maxArea(int[] heights) {
        List<Integer> ineligibleLength = new ArrayList<>();
        ineligibleLength.add(0);
        ineligibleLength.add(1);
        if (ineligibleLength.contains(heights.length)) return 0;
        int breadth = heights.length-1;
        int maxArea = 0;
        int left = 0;
        int right = heights.length-1;

        while (left<right){
            maxArea = Math.max(maxArea,breadth * Math.min(heights[left],heights[right]));
            if (heights[left]<heights[right]){
                left++;
                breadth--;
                if(heights[left]<=heights[left-1]){
                    left++;
                    breadth--;
                }
                continue;
            } else {
                right--;
                breadth--;
                if(heights[right]<=heights[right+1]) {
                    right--;
                    breadth--;
                }
                continue;
            }
        }

        return maxArea;

    }
}
