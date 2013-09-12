import java.util.Arrays;

public class testMedianOfSortedArrays {
	public static void main(String[] args)
	{
		int[] A = {2,3,4,5,6,7,8};
		int[] B = {1};
		
		testMedianOfSortedArrays a = new testMedianOfSortedArrays();
		
		System.out.println("ANS =>" + a.findMedianSortedArrays(A, B));
	}

    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //The idea is not just looking at the median, look at the kth number of two sorted array.
		//So for odd amount of numbers, just find the exactly median value, while for even amount of numbers, find two numbers and calculate the average value of the two numbers.
		if(A.length == 0 && B.length == 0)
			return (double) 0;
		
		if((A.length + B.length)%2 == 0)
		{
			//EVEN case
			int target = (A.length + B.length)/2;
			double rs1 = getMedian(A, B, target);
			System.out.println("ANS1 => "+rs1);
			target = target + 1;
			double rs2 = getMedian(A, B, target);
			System.out.println("ANS2 => "+rs2);
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
			return B[target-1];
		}
		if(B.length == 0)
		{
			return A[target-1];
		}
	
		if(target <= 2)
		{
			int ac = 0;
			int bc = 0;
			int curr = 0;
			for(int i = 0; i<target; i++)
			{
				if(ac == A.length)
				{
					curr = B[bc];
					bc++;
					continue;
				}
				if(bc == B.length)
				{
					curr = A[ac];
					ac++;
					continue;
				}
				if(A[ac] > B[bc])
				{
					curr = B[bc];
					bc++;
				}
				else
				{
					curr = A[ac];
					ac++;
				}
			}
			
			return curr;
		}
	
		if(target < A.length)
			A = Arrays.copyOfRange(A, 0, target);
		if(target < B.length)
			B = Arrays.copyOfRange(B, 0, target);
	
		int pma = (A.length)/2;
		int pmb = (target - pma - 1 - 1 >= 0 && target - pma - 1 - 1 < B.length)? (target - pma - 1 - 1) : (B.length/2);
		//int pmb = (target - pma - 1 - 1);
		System.out.println("target => " + target);
		System.out.println("A.length => "+A.length);
		System.out.println("B.length => "+B.length);
		System.out.println("pma => "+pma);
		System.out.println("pmb => "+pmb);
		
		int ma = A[pma];
		int mb = B[pmb];
		
		if(ma >= mb)
		{
			if(pma + pmb + 2 >= target)
			{
				A = Arrays.copyOfRange(A, 0, pma+1);
			}
				if(pmb == B.length-1)
					B = new int[0];
				else
					B = Arrays.copyOfRange(B, pmb+1, B.length);
				System.out.println("B.length [new] => "+B.length);
			return getMedian(A, B, target - pmb - 1);	
		}
		else
		{
			if(pma+pmb+2 >= target)
			{
			B = Arrays.copyOfRange(B, 0, pmb+1);
			}
			if(pma == A.length - 1)
				A = new int[0];
			else
				A = Arrays.copyOfRange(A, pma+1, A.length);
			return getMedian(A, B, target - pma - 1);
		}
	}
}