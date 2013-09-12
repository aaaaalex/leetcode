public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
		// It seems it only handle odd amount of numbers, should look throught more.
    }
	
	public static int getMedian(int[] A, int[] B, int l, int r)
	{
		if(l > r)
			return getMedian(B, A, Math.max(1, (A.length+B.length)/2 - A.length), Math.min(B.length, (A.length+B.length)/2));
		i = (l+r)/2;
		j = (A.length+B.length)/2 - i;
		
		if((j == 0 || A[i] > B[j]) && (j == B.length || A[i] <= B[j]))
			return A[i];
		if((j == 0 || A[i] > B[j]) && j != m && A[i] > B[j+1])
			return getMedian(A, B, l, r-1);
		return getMedian(A, B, l+1, r);
	}
}