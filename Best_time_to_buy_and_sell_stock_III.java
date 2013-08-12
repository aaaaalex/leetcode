//This version exceeds the memory limit

public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
		//The idea is to devide the array into two parts and try to the totoal profit to be maximum
		int l = prices.length;
		int max = 0;
		for(int i = 0; i < l; i++)
		{
			int tmp = getMaxProfit(0, i, prices) + getMaxProfit(i, l-1, prices);
			
			if(tmp > max)
				max = tmp;
		}
		
		return max;
    }
	
	public static int getMaxProfit(int start, int end, int[] allPrices)
	{
		if(start >= allPrices.length || start > end)
			return 0;
	
	
		int[] prices = Arrays.copyOfRange(allPrices, start, end+1);

		int max = 0;
		StockNode[] stockList = new StockNode[prices.length];
		StockNode[] sortedList = new StockNode[prices.length];
		
		for(int i = 0; i < stockList.length; i++)
		{
			stockList[i] = new StockNode();
			stockList[i].price = prices[i];
			stockList[i].date = i;
			if(prices[i] > max)
				max = prices[i];
		}
		
		
		int[][] listSorting = new int[max+1][end-start+1];
		
		for(int i = 0; i < stockList.length; i++)
		{
			int j = 0;
			int ii = stockList[i].price;
			while(listSorting[ii][j] > 0)
			{
				j++;
			}
			listSorting[ii][j] = i+1;
		}
		
//checked		
		int p = 0;
		
		for(int i = 0; i < max+1; i++)
		{
			int j = 0;
			while(listSorting[i][j] > 0)
			{
				int pp = listSorting[i][j] - 1;
				sortedList[p] = stockList[pp];
				p++;
				j++;
				if(j >= end-start+1)
					break;
			}
		}
		
		stockList = null;
		listSorting = null;
		
		max = 0;
		int hand = sortedList.length-1;
		
		for(int i = 0; i < prices.length; i++)
		{	
			int currPrice = prices[i];
			while(sortedList[hand].date <= i)
			{
				if(hand == 0)
					break;
				hand--;
			}
			int prof = sortedList[hand].price - currPrice;
			if(prof > max)
				max = prof;
			hand = sortedList.length-1;
		}
		return max;
	}
	
	static class StockNode
	{
		int price;
		int date;
	}
}