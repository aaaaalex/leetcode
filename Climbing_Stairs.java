public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n < 0)
			return 0;
		if(n <= 1)
			return 1;
		if(n == 2)
		{
			return 2;
		}
		int[] w = new int[n+1];
		w[0] = 1;
		
		for(int i = 0; i <= n - 1; i++)
		{
			w[i+1] = w[i] + w[i+1];
			if(i < n - 1)
			{
				w[i+2] = w[i] + w[i+2];
			}
		}
		
		return w[n];
    }
	
}