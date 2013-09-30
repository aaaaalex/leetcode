public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length == 0)
			return -1;
		
		return find(A, 0, A.length-1, target);
    }
	
	public static int find(int[] A, int s, int e, int target)
	{
		if(s == e)
		{
			if(A[s] == target)
				return s;
			return -1;
		}
		
		int m = (s+e)/2;
		if(A[m] == target)
			return m;
		boolean rotatedAtLeft = false;
		if(m == s)
		{
			return find(A, m+1, e, target);
		}
		
		if(m == e)
		{
			return find(A, s, m-1, target);
		}
		
		if(A[s] <= A[m-1])
		{
			if(A[s] <= target && A[m-1] >= target)
				return find(A, s, m-1, target);
			return find(A, m+1, e, target);
		}
		
		//if(A[m+1] > A[e])
		else
		{
			if(A[m+1] <= target && A[e] >= target)
				return find(A, m+1, e, target);
			else
				return find(A, s, m-1, target);
		}
	}
}