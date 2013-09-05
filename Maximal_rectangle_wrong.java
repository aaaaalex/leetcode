public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(matrix.length == 0)
			return 0;
		
        int[][] record = new int[matrix.length][matrix[0].length+1];
		int[][] record2 = new int[matrix.length+1][matrix[0].length];
		
		int max = 0;
		
		for(int i = record.length - 1; i>=0; i--)
		{
			for(int j = matrix[0].length-1; j >= 0; j--)
			{
				if(matrix[i][j] == '0')
				{
					record[i][j] = 0;
					record2[i][j] = 0;
				}
				else
				{
					record[i][j] = record[i][j+1]+1;
					record2[i][j] = record2[i+1][j]+1;
				}
			}
		}
		
		int j = 0;
		
		while(j<matrix[0].length)
		{
			int h = 0;
			int minw = matrix.length;
			int w = matrix.length;
			for(int i = 0; i<matrix.length; i++)
			{
				if(minw > record[i][j])
					minw = record[i][j];
				if(record[i][j] == 0)
				{
					if(h*w > max)
						max = h*w;
					h = 0;
					w = matrix.length;
				}
				else
				{
					h++;
					if(w > record[i][j])
						w = record[i][j];
					if(h*w > max)
						max= h*w;
				}
			}
			if(h > 0)
			{
				if(h*w > max)
					max = h*w;
			}
			
			if(minw == 0)
				j++;
			else
				j=j+minw;
		}
		
		int i =0;
		
		while(i<matrix.length)
		{
			int minh = matrix[0].length;
			int h = matrix[0].length;
			int w = 0;
			
			for(int jj = 0; jj<matrix[0].length; jj++)
			{
				if(minh > record2[i][jj])
					minh = record2[i][jj];
				if(record2[i][jj] == 0)
				{
					if(h*w > max)
						max = h*w;
					h = matrix[0].length;
					w = 0;
				}
				else
				{
					w++;
					if(h > record2[i][jj])
						h = record2[i][jj];
					if(h*w > max)
						max= h*w;
				}
			}
			if(w>0)
			{
				if(h*w > max)
					max= h*w;
			}
			if(minh == 0)
				i++;
			else
				i = i+minh;
		}
		
		return max;
    }
}