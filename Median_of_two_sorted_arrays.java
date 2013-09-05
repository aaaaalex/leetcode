public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //The idea is not just looking at the median, look at the kth number of two sorted array.
		//So for odd amount of numbers, just find the exactly median value, while for even amount of numbers, find two numbers and calculate the average value of the two numbers.
		if(A.length == 0 && b.length == 0)
			return (double) 0;
		
		if((A.length + B.length)%2 == 0)
		{
			//EVEN case
			int target = (A.length + B.length)/2;
			double rs1 = getMedian(A, B, target);
			target = target + 1;
			double rs2 = getMedian(A, B, target);
			return (rs1+rs2)/2;
		}
		else
		{
			//ODD case
			int target = (A.length + B.length + 1)/2;
			double rs = getMedian(A, B, target);
			return rs;
		}
		
    }
	
	public static int getMedian(int[] A, int[] B, int target)
	{
		if(A.length == 0)
		{
			return B[target];
		}
		if(B.length == 0)
		{
			return A[target];
		}
	
		if(target < A.length)
			A = Arrays.copyOfRange(A, 0, target);
		if(target < B.length)
			B = Arrays.copyOfRange(B, 0, target);
	
		int pma = (A.length)/2;
		int pmb = (B.length)/2;
		
		int ma = A[pma];
		int mb = B[pmb];
		
		if(ma > mb)
		{
			
		}
		else if(ma == mb)
		{
			
		}
		else
		{
		
		}
	}
}