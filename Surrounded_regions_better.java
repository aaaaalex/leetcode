public class Solution {
    public void solve(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		if(board.length == 0 || board[0].length == 0)
			return;
		
	   for(int i = 0; i < board.length; i++)
	   {
			bfs(board, i, 0);
			bfs(board, i, board[0].length-1);
	   }
	   
	   for(int i = 0; i < board[0].length; i++)
	   {
			bfs(board, 0, i);
			bfs(board, board.length-1, i);
	   }
		
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				if(board[i][j] == 'O')
					board[i][j] = 'X';
				else if(board[i][j] == '+')
					board[i][j] = 'O';
			}
		}
	}
	
	public void bfs(char[][] board, int r, int c)
	{
		if(r >= board.length || c >= board[0].length || r < 0 || c < 0)
			return;
		if(board[r][c] == '+')
			return;
		if(board[r][c] != 'O')
			return;
		int m = board.length;
		int n = board[0].length;
		Queue<Integer> q = new LinkedList<Integer> ();
		q.offer(r*n+c);
		board[r][c] = '+';
		while(!q.isEmpty())
		{
			int cur = q.poll();
			int t = cur/n;
			int s = cur%n;
			visit(board, t+1, s, q);
			visit(board, t, s+1, q);
			visit(board, t-1, s, q);
			visit(board, t, s-1, q);
		}
	}
	
	public void visit(char[][] board, int i, int j, Queue<Integer> q)
	{
		int m = board.length;
		int n = board[0].length;
		
		if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O')
			return;
			
		board[i][j] = '+';
		
		//Since j < n so it is a smart choice using n to play this one number carrying a x-y coordinate game
		q.offer(i * n+j);
	}
	
}