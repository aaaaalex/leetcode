public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int[] rs = new int[2];
		rs[0] = -1;
		rs[1] = -1;
		solve(A, 0, A.length-1, target, rs);
		return rs;
    }
	
	public static void solve(int[] A, int s, int e, int target, int[] rs)
	{
		if(s < 0 || e < s || e >= A.length || s >= A.length)
			return;
		if(target < A[s] || target > A[e])
			return;
		if(s == e)
		{
			if(A[s] == target)
			{
				if(rs[0] == -1 || rs[1] == -1)
				{
					rs[0] = s;
					rs[1] = s;
				}
				else
				{
					if(s < rs[0])
						rs[0] = s;
					if(s > rs[1])
						rs[1] = s;
				}
			}
		}
		
		int m = (s+e)/2;
		if(A[m] == target)
		{
			if(rs[0] == -1 || rs[1] == -1)
				{
					rs[0] = m;
					rs[1] = m;
				}
				else
				{
					if(m < rs[0])
						rs[0] = m;
					if(m > rs[1])
						rs[1] = m;
				}
		}
		solve(A, s, m-1, target, rs);
		solve(A, m+1, e, target, rs);
	}
	
	public static int search(int[] A, int s, int e, int target)
	{
		if(s < 0 || e < s || e >= A.length || s >= A.length)
			return -1;
	
		if(s == e)
		{
			if(A[s] == target)
				return s;
			return -1;
		}
		
		int m = (s+e)/2;
		if(A[m] == target)
			return m;
		
		if(A[m] > target)
			return search(A, s, m-1, target);
		else
			return search(A, m+1, e, target);
	}
	
}