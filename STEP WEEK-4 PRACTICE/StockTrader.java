public class StockTrader {

    public static int maxProfit(int[] prices) {
        // Handle empty or single-element arrays where no transaction can happen
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Keep track of the lowest price seen so far
        int minPrice = prices[0];
        // Keep a running record of the largest profit seen
        int maxProfit = 0;

        // Walk through the array once, left to right
        for (int i = 1; i < prices.length; i++) {
            // Work out the profit if you sold today
            int currentProfit = prices[i] - minPrice;

            // If this profit is greater than our record, update it
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }

            // Update the lowest price seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test Case 1: Profitable trade exists
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Output 1: " + maxProfit(prices1)); // Expected: 5

        // Test Case 2: Prices only fall
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Output 2: " + maxProfit(prices2)); // Expected: 0
    }
}