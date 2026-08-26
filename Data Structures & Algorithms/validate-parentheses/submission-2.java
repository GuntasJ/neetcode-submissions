class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c== '[') {
                stack.addFirst(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.getFirst();
                if (topChar == '(' && c != ')') {
                    return false;
                }
                if (topChar == '{' && c != '}') {
                    return false;
                }
                if (topChar == '[' && c != ']') {
                    return false;
                }
                stack.removeFirst();
            }
        }
        return stack.isEmpty();
    }
}
