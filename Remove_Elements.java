public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		int l = A.length;
		
		for(int i = 0; i < l; i++)
		{
			if(A[i] == elem)
			{
				swap(A, i, l-1);
				i--;
				l--;
			}
		}
		
		return l;
    }
	
	
	public static void swap(int[] A, int s, int t)
	{
		int tmp = A[s];
		A[s] = A[t];
		A[t] = tmp;
	}
}