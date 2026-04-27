class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b + a);
                }
                case "-" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                }
                case "*" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b * a);
                }
                case "/" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a); // integer division truncates toward 0 in Java
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}

