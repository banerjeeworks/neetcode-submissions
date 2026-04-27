class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean duplicatePresence = false;
        Map<Integer, Boolean> trackMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (trackMap.containsKey(nums[i])) {
                duplicatePresence = true;
                break;
            } else {
                trackMap.put(nums[i], true);
            }
        }
        return duplicatePresence;
    }
}
