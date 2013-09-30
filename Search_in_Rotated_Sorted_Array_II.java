public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(A == null || A.length == 0)
			return false;
		return solve(A, target, 0, A.length-1);
    }
	
	public static boolean solve(int[] A, int target, int s, int e)
	{
		if(s == e)
		{
			if(A[s] ==  target)
				return true;
			else
				return false;
		}
		
		int m = (s+e)/2;
		int mval = A[m];
		if(mval == target)
			return true;
			
		if(m == s)
		{
			return solve(A, target, s+1, e);
		}
		
		if(m == e)
		{
			return solve(A, target, s, e-1);
		}
		if(A[m-1] >= A[s])
		{
			if(A[m-1] == A[s] && (m-1) != s)
			{
				//Found duplicate
				if(solve(A, target, s, m-1))
					return true;
				return solve(A, target, m+1, e);
			}
			else
			{
				if(A[s] == target || A[m-1] ==  target)
					return true;
				if(A[s] < target && A[m-1] > target)
					return solve(A, target, s, m-1);
				return solve(A, target, m+1, e);
			}
		}
		else
		{
			if(A[m+1] == A[e] && e != m+1)
			{
				//Found duplicate
				if(solve(A, target, m+1, e))
					return true;
				return solve(A, target, s, m-1);
			}
			else
			{
				if(A[m+1] ==  target || A[e] == target)
					return true;
				if(A[m+1] < target && A[e] > target)
					return solve(A, target, m+1, e);
				return solve(A, target, s, m-1);
			}
		}
	}
}