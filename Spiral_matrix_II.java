public class Solution {
    public int[][] generateMatrix(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		int[][] matrix = new int[n][n];
		
		if(n == 0)
			return matrix;
		
		exec(1, n, n, 0, matrix);
		return matrix;
	}
	
	public static void exec(int n, int c, int r, int k, int[][] matrix)
	{
		//The reason I wrote these cases is just for reviewing the previous question.
		//If just talk about this question, we don't have to care about those cases. Since both c and r will be always the same.
		
		if(c == 0 || r == 0)
			return;
			
		if(c == 1)
		{
			for(int i = 0; i < r; i++)
			{
				matrix[i+k][k] = n;
				n++;
			}
			return;
		}
		
		if(r == 1)
		{
			//actually will never reach this case in this question
			//Since r and c will always be the same.
			for(int i = 0; i < c; i++)
			{
				matrix[i+k][k] = n;
				n++;
			}
			return;
		}
		
		for(int i = 0; i < c-1; i++)
		{
			matrix[k][i+k] = n;
			n++;
		}
		
		for(int i = 0; i < r-1; i++)
		{
			matrix[i+k][k+c-1] = n;
			n++;
		}
		
		for(int i = c-1; i > 0; i--)
		{
			matrix[r+k-1][i+k] = n;
			n++;
		}
		
		for(int i = r-1; i > 0; i--)
		{
			matrix[i+k][k] = n;
			n++;
		}
		
		exec(n, c-2, r-2, k+1, matrix);
		
	}
}