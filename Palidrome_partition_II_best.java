public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int l = s.length();
		int[] dp = new int[l+1];
		boolean[][] isPal = new boolean[l][l];
		
		for(int i = 0; i != l+1; i++)
		{
			dp[i] = l-1-i;
		}
		
		for(int i = l-2; i>=0; i--)
		{
			for(int j = i; j < l; j++)
			{
				if(s.charAt(i) == s.charAt(j) && (j <= i+2 || isPal[i+1][j-1]))
				{
					isPal[i][j] = true;
					dp[i] = Math.min(dp[i], 1+dp[j+1]);
				}
			}
		}
		
		return dp[0];
    }
}