public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] aa = new int[A.length+1];
		for(int i = 0; i<A.length+1; i++)
		{
			if(i == 0)
			{
				aa[i] = 0;
				continue;
			}
			
			aa[i] = aa[i-1] + A[i-1];
		}
		
		int min = 0;
		int max = A[0];
		
		for(int i = 1; i<A.length+1; i++)
		{
			if(aa[i] - min > max)
				max = aa[i] - min;
			
			if(aa[i] < min)
			{
				min = aa[i];
				continue;
			}
			
			if(aa[i] - min > max)
				max = aa[i] - min;
		}
		
		return max;
    }
}