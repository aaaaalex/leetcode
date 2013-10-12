public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix == null)
			return;
		int row = matrix[0].length;
		int col = matrix.length;
		
		int zerocol = -1;
		int zerorow = -1;
		
		for(int i = 0; i < Math.min(row, col); i++)
		{
			int tmpzcol = zerocol;
			int tmpzrow = zerorow;
			zerocol = -1;
			zerorow = -1;
			
			if(matrix[i][i] == 0)
			{
				zerocol = i;
				zerorow = i;
				zerosBack(matrix, i, i, true);
				zerosBack(matrix, i, i, false);
			}
			if(i >= 1)
			{
				if(matrix[i-1][i] == 0)
					zerorow = i;
				if(matrix[i][i-1] == 0)
					zerocol = i;
			}
			for(int ii = i; ii < row; ii++)
			{
				if(matrix[i][ii] == 0)
				{
					if(ii != i)
					{
						zerocol = i;
					}
					if(i >= 1 && matrix[i-1][ii] != 0 && ii != i)
					{
						zerosBack(matrix, i, ii, false);
					}
				}
				
				if(i >= 1 && matrix[i-1][ii] == 0)
				{
					matrix[i][ii] = 0;
					/* if(ii == i)
					{
						zerorow = ii;
					} */
				}
			}
			
			for(int jj = i; jj < col; jj++)
			{
				if(matrix[jj][i] == 0)
				{
					if(jj != i)
					{
						zerorow = i;
					}
					if(i >= 1 && matrix[jj][i-1] != 0 && jj != i)
					{
						zerosBack(matrix, jj, i, true);
					}
				}
				if(i >= 1 && matrix[jj][i-1] == 0)
				{
					matrix[jj][i] = 0;
					/* if(jj == i)
					{
						zerocol = jj;
					} */
				}
			}	
			makeZeros(matrix, tmpzcol, tmpzrow);
		}
		makeZeros(matrix, zerocol, zerorow);
    }
	
	public static void makeZeros(int[][] matrix, int col, int row)
	{
		if(row >= 0)
		{
			for(int i = 0; i < matrix.length; i++)
			{
				matrix[i][row] = 0;
			}
		}
		if(col >= 0)
		{
			for(int i = 0; i < matrix[0].length; i++)
			{
				matrix[col][i] = 0;
			}
		}
	}
	
	public static void zerosBack(int[][] matrix, int col, int row, boolean up)
	{
		if(up)
		{
			for(int i = row; i >=0; i--)
				matrix[col][i] = 0;
		}
		else
		{
			for(int i = col; i >=0; i--)
				matrix[i][row] = 0;
		}
	}
}