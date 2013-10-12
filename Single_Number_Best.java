public class Solution {
    public int singleNumber(int[] A) {
		//The best way should using bit operator
		if(A == null || A.length == 0 || A.length %2 == 0)
			return -1;
		if(A.length == 1)
			return A[0];
		
		int res = 0;
		
		for(int i = 0; i < A.length; i++)
		{
			res = res ^ A[i];
		}
		return res;
	}
}