public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] records = new int[32];
		
		for(int i = 0; i < A.length; i++)
		{
			for(int j = 0; j < 32; j++)
			{
				records[j] += (A[i] >> j) & 1;
				records[j] %= 3;
			}
		}
		
		int res = 0;
		
		for(int i = 0; i < 32; i++)
		{
			res += records[i] << i;
		}
		
		return res;
    }
}