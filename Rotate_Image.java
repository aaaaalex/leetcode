public class Solution {
//Have not tested online yet!!!
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(matrix.length <= 1)
			return;
		solve(matrix, 0);
    }
	
	public static void solve(int[][] matrix, int c)
	{
		int s = matrix.length;
		int l = s;
		if(s%2 == 0)
		{
			if(s/2 < c)
				return;
		}
		
		if(s%2 != 0)
		{
			if((s+1)/2 == c)
				return;
		}
		
		for(int i = 0; i < s-2*c-1; i++)
		{
			int[] currPos = new int[2];
			currPos[0] = c;
			currPos[1] = c+i;
			int tmp = matrix[currPos[0]][currPos[1]];
			for(int j = 0; j < 4; j++)
			{
				currPos = getPos(currPos, l);
				int t = matrix[currPos[0]][currPos[1]];
				matrix[currPos[0]][currPos[1]] = tmp;
				tmp = t;
			}
		}
		solve(matrix, c+1);
	}
	
	public static int[] getPos(int[] oldPos, int l)
	{
		int[] newPos = new int[2];
		
		int oldX = oldPos[0];
		int oldY = oldPos[1];
		
		newPos[0] = oldY;
		newPos[1] = l-1-oldX;
		
		return newPos;
	}
}