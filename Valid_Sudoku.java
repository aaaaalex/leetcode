public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				int p = (i-1)*3;
				int pp = (j-1)*3;
				if(!check(3, p, pp, board))
					return false;
			}
		}
		
		return check(9, 0, 0, board);
    }
	
	
	boolean check(int len, int start, int start2, char[][] board)
	{
			
		int tmp = 0;
		for(int i = 0; i < len; i++)
		{
			if(len == 9)
				tmp = 0;
			for(int j = 0; j < len; j++)
			{
				if(board[start+i][start2+j] == '.')
					continue;
				int ii = board[start+i][start2+j]-'0';
				if((tmp & (1<<ii)) == 1)
					return false;
				else
					tmp = tmp ^ (1<<ii);
			}
		}
		
		if(len == 9)
		{
			tmp = 0;
			for(int j = 0; j < len; j++)
			{
				if(len == 9)
					tmp = 0;
				for(int i = 0; i < len; i++)
				{
					if(board[start+i][start2+j] == '.')
						continue;
					int ii = board[start+i][start2+j]-'0';
					if((tmp & (1<<ii)) == 1)
						return false;
					else
						tmp = tmp ^ (1<<ii);
				}
			}
		}
		
		return true;
	}
}