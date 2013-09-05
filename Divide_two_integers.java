/*
Should try bit operator methods
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(divisor == 0)
			return 0;
		
		if(dividend == 0)
			return 0;
		
		if(dividend == divisor)
		{
			return 1;
		}
		
		if(divisor == 1)
			return dividend;
		if(divisor == -1)
			return 0-dividend;

		long c = 0;
		boolean rollover = true;
		
		if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
			rollover = false;
		if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			rollover = true;

		long longdividend = (long)Math.abs(dividend);
		if(longdividend < 0)
			longdividend = 0 - longdividend;
		long longdivisor = (long)Math.abs(divisor);
		if(longdivisor < 0)
			longdivisor = 0 - longdivisor;
		long orig = longdivisor;
		long cc = 1;
		
		while(longdividend >= orig)
		{
			if(longdividend < longdivisor)
			{
				while(longdividend < longdivisor)
				{
					longdivisor -= orig;
					cc--;
				}
				longdividend -= longdivisor;
				c += cc;
				continue;
			}
			
			longdividend -= longdivisor;
			c += cc;
			longdivisor += orig;
			cc++;
		}
		
		if(rollover)
			c = 0 - c;
			
		return (int)c;
    }
}