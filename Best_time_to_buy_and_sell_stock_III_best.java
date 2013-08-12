public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(prices.length <= 1)
			return 0;
		
        int max = 0;
		int min = prices[0];
		
		int[] forward = new int[prices.length];
		int[] backward = new int[prices.length];
		
		for(int i = 0; i < prices.length; i++)
		{
			if(prices[i] < min)
			{
				min = prices[i];
			}
			if(prices[i] - min > max)
			{
				max = prices[i] - min;
			}
			forward[i] = max;
		}
		
		int pmax = prices[prices.length - 1];
		
		for(int i = prices.length - 1; i >= 1; i--)
		{
			if(prices[i] > pmax)
			{
				pmax = prices[i];
			}
			if(pmax - prices[i] + forward[i - 1] > max)
			{
				max = pmax - prices[i] + forward[i - 1];
			}
			
		}
		return max;
    }
}