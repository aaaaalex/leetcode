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
		LinkedList<Integer> r = new LinkedList<Integer> ();
		
		while(j < matrix[0].length)
		{
			r.clear();
			int minw = matrix[0].length;
			for(int i =0; i < matrix.length; i++)
			{
				if(record[i][j] < minw)
					minw = record[i][j];
				if(r.isEmpty() || record[i][j] > record[r.peekLast()][j])
					r.add(i);
				else
				{
					int start = r.pollLast();
					int height = record[start][j];
					int width = (r.isEmpty()) ? i : i-r.peekLast() - 1;
					max = Math.max(max, height*width);
					i--;
				}
			}
			while(!r.isEmpty())
			{
				int start = r.pollLast();
				int height = record[start][j];
				int width = (r.isEmpty() ? matrix.length: matrix.length - r.peekLast() - 1);
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