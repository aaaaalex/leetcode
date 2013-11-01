public class Solution {
    public int numTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(n < 1)
			return 0;
		
		int[] ways = new int[n+1];
		ways[0] = 1;
		//ways[1] = 1;
		for(int i = 1; i<=n; i++)
		{
			for(int j = 0; j<=i-1; j++)
			{
				int ln = j;
				int rn = i-j-1;
				int lways = ways[ln];
				int rways = ways[rn];
				ways[i] += lways * rways;
			}
		}
		
		return ways[n];
    }
}