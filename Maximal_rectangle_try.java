public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(matrix.length == 0)
			return 0;
		
        int[][] record = new int[matrix.length][matrix[0].length+1];
		
		int max = 0;
		
		for(int i = record.length - 1; i>=0; i--)
		{
			for(int j = matrix[0].length-1; j >= 0; j--)
			{
				if(matrix[i][j] == '0')
				{
					record[i][j] = 0;
				}
				else
				{
					record[i][j] = record[i][j+1]+1;
				}
			}
		}
		
		int j = 0;
		Stack<Integer> r;
		
		while(j < matrix[0].length)
		{
			r = new Stack<Integer> ();
			int minw = matrix[0].length;
			for(int i =0; i < matrix.length; i++)
			{
				if(record[i][j] < minw)
					minw = record[i][j];
				if(r.empty() || record[i][j] > record[r.peek()][j])
					r.push(i);
				else
				{
					int start = r.pop();
					int height = record[start][j];
					int width = (r.empty()) ? i : i-r.peek() - 1;
					max = Math.max(max, height*width);
					i--;
				}
			}
			while(!r.empty())
			{
				int start = r.pop();
				int height = record[start][j];
				int width = (r.empty() ? matrix.length: matrix.length - r.peek() - 1);
				max = Math.max(max, height*width);
			}
			
			if(minw == 0)
				j++;
			else
				j=j+minw+1;
		}
		
		return max;
    }
}