public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0;
		for(int i = 0; i < prices.length - 1; i++){
			int pb = prices[i];
			for(int j = i+1; j < prices.length; j++){
				int ps = prices[j];
				if((ps - pb) > max)
					max = ps - pb;
			}
		}
		return max;
    }
}