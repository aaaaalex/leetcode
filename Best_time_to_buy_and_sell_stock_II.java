public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int max = 0;
		int temp = 0;
		boolean empty = true;
		
		for(int i = 0; i < prices.length - 1; i++)
		{
			if(prices[i] < prices[i+1])
				max += prices[i+1] - prices[i];
		}
		return max;
    }
}