public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		//The idea is use quick sort check if each element get parterner
		if(A == null || A.length == 0)
			//return null;
			return -1;
		if(A.length == 1)
			return A[0];
		if(A.length % 2 == 0)
			//return null;
			return -1;
		
		int p = quickSort(A, 0, A.length-1);
		if(p >= 0)
			return A[p];
		return -1;
		
    }
	
	public static int quickSort(int[] A, int s, int e)
	{
		if(s < e)
		{
			int[] p = partition(A, s, e);
			
			if(p[0] == p[1])
				return p[0];
			
			int l1 = p[0] - s+1;
			int l2 = e-p[1];
			
			int p1 = -1;
			int p2 = -1;
			
			if(l1 %2 != 0)
				p1 = quickSort(A, s, p[0]);
			if(l2 % 2 != 0)
				p2 = quickSort(A, p[1]+1, e);
				
			if(p1 >= 0)
				return p1;
			if(p2 >= 0)
				return p2;
			return -1;
		}
		
		return -1;
	}
	
	public static int[] partition(int[] A, int s, int e)
	{
		int b = A[e];
		int p = s-1;
		int p2 = s-1;
		for(int i = s; i < e-1; i++)
		{
			if(A[i] < b)
			{
				p2++;
				p++;
				int tmp = A[p2];
				A[p2] = A[p];
				A[p] = A[i];
				A[i] = tmp;
				
				/* int tmp = A[p];
				A[p] = A[i];
				A[i] = tmp; */
			}
			else
			{
				if(A[i] == b)
				{
					p2++;
					int tmp = A[p2];
					A[p2] = A[i];
					A[i] = tmp;
				}
			}
		}
		
		p2++;
		int tmp = A[p2];
		A[p2] = A[e];
		A[e] = tmp;
		int[] rs = new int[2];
		rs[0] = p;
		rs[1] = p2;
		return rs;
	}
}