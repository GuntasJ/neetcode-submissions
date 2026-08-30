class Solution {
    public int hammingWeight(int n) {
        int x = 0;
        for (int i = 0; i < 32; i++) {
            x += (n & (int)Math.pow(2, i)) >> i;
        }
        return x;
    }
}
