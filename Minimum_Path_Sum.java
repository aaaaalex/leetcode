public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(grid.length == 0 || grid[0].length == 0)
			return 0;
			
		
		int[][] record = new int[grid.length][grid[0].length];
		for(int i = 0; i<grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				if(i == 0 && j == 0)
					record[i][j] = grid[i][j];
				else
					record[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i<grid.length; i++)
		{
			for(int j = 0; j<grid[0].length; j++)
			{
				if(j+1 < grid[0].length && record[i][j] + grid[i][j+1] < record[i][j+1])
					record[i][j+1] = record[i][j]+grid[i][j+1];
				if(i+1 < grid.length && record[i][j] + grid[i+1][j] < record[i+1][j])
					record[i+1][j] = record[i][j]+grid[i+1][j];
			}
		}
		return record[grid.length-1][grid[0].length-1];
    }
}