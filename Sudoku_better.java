public class Solution {
    public void solveSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		process(board);
	}
	
	public static boolean process(char[][] board)
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if(board[i][j] == '.')
				{
					for(int ii = 0; ii < 9; ii++)
					{
						char c = (char) (ii+'1');
						board[i][j] = c;
						if(isValid(board, i, j, c) && process(board))
							return true;
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		//Reaching here means did not get any '.' which means comes to the ending
		return true;
	}
	
	public static boolean isValid(char[][] board, int r, int c, char v)
	{
		//boolean[] flag = new boolean [9];
		//HashSet<Character> contained = new HashSet<Character> ();
		for(int i = 0; i < 9; i++)
		{
			if(board[i][c] == v)
			{
				if(i!=r)
					return false;
			}
		}
		
		for(int i = 0; i < 9; i++)
		{
			if(board[r][i] == v)
			{
				if(i != c)
					return false;
			}
		}
		
		int rs = (r/3)*3;
		int cs = (c/3)*3;
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j <3; j++)
			{
				if(rs+i!= r && cs + j!=c && board[rs+i][cs+j] == v)
					return false;
			}
		}
		
		return true;
	}
	
}