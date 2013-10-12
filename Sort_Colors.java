public class Solution {
    public void sortColors(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		int i = -1;
		int j = -1;
		for(int c = 0; c < A.length; c++)
		{
			if(A[c] == 0)
			{
				i++;
				j++;
				A[c] = A[j];
				A[j] = A[i];
				A[i] = 0;
			}
			else if(A[c] == 1)
			{
				j++;
				A[c] = A[j];
				A[j] = 1;
			}
			else if(A[c] == 2)
			{
				continue;
			}
		}
    }
}