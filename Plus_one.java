public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		boolean isAllNine = true;
		for(int i = 0; i < digits.length; i++)
		{
			if(digits[i] != 9)
				isAllNine = false;
		}
		
		if(isAllNine)
		{
			int[] rs = new int[digits.length+1];
			rs[0] = 1;
			return rs;
		}
		
		int[] rs = new int[digits.length];
		int prev = 0;
		for(int i = digits.length-1; i >= 0; i--)
		{
			int sum = digits[i] + prev;
			if(i == digits.length-1)
				sum++;
			if(sum >= 10)
			{
				rs[i] = sum - 10;
				prev = 1;
			}
			else
			{
				rs[i] = sum;
				prev = 0;
			}
		}
		
		return rs;
    }
}