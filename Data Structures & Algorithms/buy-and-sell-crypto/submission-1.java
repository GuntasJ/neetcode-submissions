class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) { return 0;}

        int[] maxSellingPrices = new int[prices.length];
        maxSellingPrices[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxSellingPrices[i] = Math.max(prices[i], maxSellingPrices[i + 1]);
        }
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, maxSellingPrices[i] - prices[i]);
        }
        return result;
    }
}
