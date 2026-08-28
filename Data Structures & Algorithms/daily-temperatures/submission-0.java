class Solution {
    private static record Node(int index, int value){} 
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Node> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            int j = 0;
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.getFirst().index()]) {
                j++;
                Node node = stack.removeFirst();
                result[node.index()] = j;
                j += node.value();
            }
            stack.addFirst(new Node(i, j));
        }
        return result;
    }
}
