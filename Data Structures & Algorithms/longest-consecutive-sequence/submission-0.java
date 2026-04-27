class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: put all numbers into a set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: look for starts of sequences
        for (int num : set) {
            // Only start a new sequence if num - 1 is not present
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                // Step 3: count how far this sequence goes
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                // Step 4: keep track of the best
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
