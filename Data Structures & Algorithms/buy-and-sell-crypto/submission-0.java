class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int n=prices.length;
        if (n==0 || n==1){
            return maxProfit;
        }

        for (int p : prices) {
            if (p < minPrice) minPrice = p;// best buy so far
            else maxProfit = Math.max(maxProfit, p - minPrice); // sell today
        }
        
        return maxProfit;
    }
}
