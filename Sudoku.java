public class Solution {
    public void solveSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(board == null || board.length == 0 || board[0].length == 0)
			return;
			
		fill(board, 0, 0);
    }
	
	public static boolean fill(char[][] board, int r, int c)
	{
		if(c >= board[0].length)
			return true;
			
		if(board[r][c] == '.')
		{
			for(int i = 1; i < 10; i++)
			{
				char curr = (char)(i+'0');
				if(check(board, r, c, curr))
				{
					board[r][c] = curr;
					if(r == board.length - 1)
					{
						if(fill(board, 0, c+1))
							return true;
						else
							board[r][c] = '.';
					}
					else
					{
						if(fill(board, r+1, c))
							return true;
						else
							board[r][c] = '.';
					}
				}
			}
			return false;
		}
		else
		{
			if(r == board.length - 1)
				return fill(board, 0, c+1);
			return fill(board, r+1, c);
		
		}
	}
	
	public static boolean check(char[][] board, int r, int c, char v)
	{
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