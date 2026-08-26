class MinStack {
    
    private static record Node(int value, int minValueSoFar) {}
    private int minValue;
    private final Deque<Node> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minValue = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        var node = new Node(val, minValue);
        stack.addFirst(node);

        minValue = Math.min(val, minValue);
    }
    
    public void pop() {
        var node = stack.removeFirst();
        minValue = node.minValueSoFar();
    }
    
    public int top() {
        return stack.getFirst().value();
    }
    
    public int getMin() {
        return minValue;
    }
}
