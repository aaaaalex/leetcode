public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		//The idea is to scan vertically first and then horizontal
		
		int l = matrix[0].length;
		int row =  bSearch2(matrix, target, 0, matrix.length-1, 0);
		if(row < 0)
			return false;
		if(matrix[row][0] == target)
			return true;
		
		int col = bSearch(matrix[row], target, 0, l-1);
		
		//System.out.println("COL => "+col);
		
		if(col < 0)
			return false;
		if(matrix[row][col] == target)
			return true;

		//System.out.println("ROW => "+row);
		
		return false;
    }
	
	public static int bSearch(int[] data, int target, int s, int e)
	{
		if(s == e)
			return s;
		if(target < data[s])
			return -1;
		if(target > data[e])
			return e;
		if(e-s+1 <= 3)
		{
			for(int i = e-s; i >= 0; i--)
			{
				//System.out.println("i+s = "+i+s +"&& val => "+data[i+s]);
				if(data[i+s] <= target)
					return i+s;
			}
		}
		int m = (e+s)/2;
		int mval = data[m];
		
		if(mval == target)
			return m;
		if(mval > target)
			return bSearch(data, target, s, m-1);
		else
			return bSearch(data, target, m, e);
	}
	
	public static int bSearch2(int[][] data, int target, int s, int e, int row)
	{
		if(s == e)
			return s;
		if(target < data[s][row])
			return -1;
		if(target > data[e][row])
			return e;
		if(e-s+1 <= 3)
		{
			for(int i = e-s; i >= 0; i--)
			{
				//System.out.println("data["+i+s+"]["+row+"] = "+data[i+s][row]);
				if(data[i+s][row] <= target)
					return i+s;
			}
		}
		int m = (e+s)/2;
		int mval = data[m][row];
		
		if(mval == target)
			return m;
		if(mval > target)
			return bSearch2(data, target, s, m-1, row);
		else
			return bSearch2(data, target, m, e, row);
	}
}