public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		//In the following case, return error
		if(m+n > A.length)
			return;
			
		if(A.length == 0 && B.length == 0)
			return;
		
        for(int i = m-1; i >= 0; i--)
		{
			A[i+n] = A[i];
		}
		
		int i = n;
		int j = 0;
		int c = 0;
		while(true)
		{
			if(c == A.length)
				break;
			if(i == A.length && j == n)
				break;
			if(j == n)
				break;
			if(i == A.length)
			{
				A[c] = B[j];
				j++;
				c++;
				continue;
			}
			int currA = A[i];
			int currB = B[j];
			int min;
			
			if(currA <= currB)
			{
				min = currA;
				i++;
			}
			else
			{
				min = currB;
				j++;
			}
			
			A[c] = min;
			c++;
		}
    }
}