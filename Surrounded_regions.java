/*This method will cause stack overflow!*/

public class Solution {
    public void solve(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		if(board.length == 0 || board[0].length == 0)
			return;
		
		if(board.length == 1 || board[0].length == 1)
		{
			for(int i = 0; i < board.length; i++)
			{
				for(int j = 0; j < board[0].length; j++)
				{
					board[i][j] = 'O';
				}
			}
			return;
		}
	   
	    //boolean[][] record = new boolean[board.length][board[0].length];
	   boolean[][] ifvisited = new boolean[board.length][board[0].length];
	   
	   for(int i = 0; i < board.length; i++)
	   {
			linkdraw(board, ifvisited, i, 0);
			linkdraw(board, ifvisited, i, board[0].length-1);
	   }
	   
	   for(int i = 0; i < board[0].length; i++)
	   {
			linkdraw(board, ifvisited, 0, i);
			linkdraw(board, ifvisited, board.length-1, i);
	   }
		
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				if(board[i][j] == 'O')
				{
					if(!ifvisited[i][j])
						board[i][j] = 'X';
				}
			}
		}
	}
	
	public void linkdraw(char[][] board, boolean[][] ifvisited, int r, int c)
	{
		if(r >= board.length || c >= board[0].length || r < 0 || c < 0)
			return;
		if(ifvisited[r][c])
			return;
		if(board[r][c] != 'O')
			return;
		
		ifvisited[r][c] = true;
		
		linkdraw(board, ifvisited, r+1, c);
		linkdraw(board, ifvisited, r, c+1);
		linkdraw(board, ifvisited, r-1, c);
		linkdraw(board, ifvisited, r, c-1);
	}
	
}