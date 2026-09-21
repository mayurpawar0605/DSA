class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;

        // for(int i = 0; i < n-1; i++){
        //     for(int j = i; j < n; j++){
        //         if(prices[i] < prices[j]){
        //             int profit = prices[j] - prices[i];
        //             maxProfit = Math.max(profit,maxProfit);
        //         }
        //     }
        // }

        int i = n-1;

        int maxi = 0;
        while(i > 0){
             if(prices[i] > maxi){
                maxi = prices[i];

                int j = 0;
                while(j < i){
                    int profit = prices[i] - prices[j];
                    maxProfit = Math.max(profit,maxProfit);
                    j++;
                }
            }
            i--;
        }

        return maxProfit;
    }
}