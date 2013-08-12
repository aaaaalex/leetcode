public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = prices.length;
		int max = 0;
		for(int i = 0; i < l; i++)
		{
			int tmp = getProfit(0, i, prices) + getProfit(i, l-1, prices);
			
			if(tmp > max)
				max = tmp;
		}
		
		return max;
    }
	
	public int getProfit(int s, int e, int[] allPrices) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(s >= allPrices.length || e < s)
			return 0;
			
		int[] prices = Arrays.copyOfRange(allPrices, s, e+1);
		
		if(prices.length == 0)
			return 0;
		
		int max = 0;
		int min = prices[0];
		for(int i = 0; i < prices.length; i++)
		{
			if(prices[i] < min)
				min = prices[i];
			if(prices[i] - min > max)
			{
				max = prices[i] - min;
			}
		}
		return max;
    }
}