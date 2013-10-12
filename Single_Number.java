public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		//The idea is use quick sort to sort in place first then travel to see which one is the unique.
		if(A == null || A.length == 0)
			//return null;
			return -1;
		if(A.length == 1)
			return A[0];
		if(A.length % 2 == 0)
			//return null;
			return -1;
		
		quickSort(A, 0, A.length-1);
		
		for(int i = 0; i < A.length; i++)
		{
			if(i == A.length-1)
				return A[i];
			if(A[i] == A[i+1])
			{
				i++;
			}
			else
			{
				return A[i];
			}
		}
		//Cannot return null since int cannot be null;
		//return null;
		return -1;
    }
	
	public static void quickSort(int[] A, int s, int e)
	{
		if(s < e)
		{
			int[] p = partition(A, s, e);
			quickSort(A, s, p[0]);
			quickSort(A, p[1]+1, e);
		}
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