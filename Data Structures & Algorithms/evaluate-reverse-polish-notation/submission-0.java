class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>(List.of("+", "*", "/", "-"));
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                var b = stack.removeFirst();
                var a = stack.removeFirst();
                switch(token) {
                    case "+" -> stack.addFirst(a + b);
                    case "-" -> stack.addFirst(a - b);
                    case "*" -> stack.addFirst(a * b);
                    case "/" -> stack.addFirst(a / b);
                    default -> {}
                }
            } else {
                stack.addFirst(Integer.parseInt(token));
            }
        }
        return stack.getFirst();
    }
}
