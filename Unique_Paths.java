public class Solution {
    public int uniquePaths(int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		if(m == 0 || n == 0)
			return 0;
			
		int[][] rs = new int[m+1][n+1];
			
		rs[1][1] = 1;
			
		for(int i = 1; i <= m; i++)
		{
			for(int j = 1; j <= n; j++)
			{
				if(i == 1 && j == 1)
					continue;

					rs[i][j] = rs[i-1][j]+rs[i][j-1];
			}
		}
			
		return rs[m][n];
    }
}