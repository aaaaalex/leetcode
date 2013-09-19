public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int l = A.length;
		int curr = 0;
		int count = 1;
		
		for(int i = 0; i < l-1; i++)
		{
			if(i == 0)
				curr = A[i];
			if(curr == A[i+1])
			{
				if(count >= 2)
				{
					modArray(A, i);
					i--;
					l--;
				}
				else
				{
					count++;
				}
			}
			else
			{
				curr = A[i+1];
				count = 1;
			}
		}
		
		return l;
    }
	
	public static void modArray(int[] A, int p)
	{
		for(int i = p; i < A.length-1; i++)
		{
			A[i] = A[i+1];
		}
	}
}