public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1)
			return 0;

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
			
		int[][] rs = new int[m+1][n+1];
			
		rs[1][1] = 1;
			
		for(int i = 1; i <= m; i++)
		{
			for(int j = 1; j <= n; j++)
			{
				if(i == 1 && j == 1)
					continue;

				if(obstacleGrid[i-1][j-1] == 1)
					continue;
				rs[i][j] = rs[i-1][j]+rs[i][j-1];
			}
		}
			
		return rs[m][n];
    }
}