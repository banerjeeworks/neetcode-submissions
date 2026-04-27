class Solution {
    public boolean isValid(String s) {
        // Quick fail: odd length can never be valid
        if (s == null || (s.length() % 2) != 0) {
            return false;
        }

        // Map closing -> corresponding opening
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // It's a closing bracket, stack must not be empty
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                // The type must match
                if (top != pairs.get(c)) {
                    return false;
                }
            }
        }

        // All openings must be closed
        return stack.isEmpty();
    }
}
