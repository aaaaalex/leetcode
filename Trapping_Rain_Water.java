public class Solution {
    public int trap(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int rs = 0;
		if(A == null || A.length < 3)
			return rs;
		
		boolean start = false;
		
		int[] leftMostHight = new int[A.length];
		int[] rightMostHight = new int[A.length];
		
		int tmp = 0;
		for(int i = 0; i < A.length; i++)
		{
			leftMostHight[i] = tmp;
			if(A[i] > tmp)
			{
				tmp = A[i];
			}
		}
		tmp = 0;
		for(int i = A.length-1; i >= 0; i--)
		{
			rightMostHight[i] = tmp;
			if(A[i] > tmp)
			{
				tmp = A[i];
			}
			if(A[i] > Math.min(rightMostHight[i], leftMostHight[i]))
			{
				continue;
			}
			else
			{
				rs = rs+Math.min(rightMostHight[i], leftMostHight[i]) - A[i];
			}
		}
		
		return rs;
    }
}