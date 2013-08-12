/******************************************
This version still get problems and errors
******************************************/

public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0;
		int vmax = 0;
		for(int i = 0; i < prices.length; i++){
			if(prices[i] > vmax)
				vmax = prices[i];
		}
		
		int[] records = new int[vmax+1];
		for(int i = 0; i < prices.length; i++){
			records[prices[i]]++;
		}
		
		int hand = prices.length - 1;
		
		for(int i = 0; i < prices.length; i++){
			int pb = prices[i];
			records[pb]--;
			while(records[hand] == 0 && hand > pb)
				hand--;
			if((records[hand] - pb) > max)
				max = records[hand] - pb;
		}
		
		return max;
    }
}