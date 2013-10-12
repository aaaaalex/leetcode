public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(A == null || A.length == 0)
			return 0;
		
        return solve(A, target, 0, A.length-1);
    }
	
	public static int solve(int[] A, int target, int s, int e)
	{
		if(s == e)
		{
			if(A[s] >= target)
			{
				return s;
			}
			return s+1;
		}
		
		if(A[s] >= target)
			return s;
		if(A[e] < target)
			return e+1;
		if(A[e] == target)
			return e;
		
		int m = (s+e)/2;
		int mval = A[m];
		if(mval == target)
			return m;
		if(mval > target)
		{
			if(m == s)
				return s;
			return solve(A, target, s, m-1);
		}
		else
		{
			if(m == e)
				return e+1;
			return solve(A, target, m+1, e);
		}
	}
}