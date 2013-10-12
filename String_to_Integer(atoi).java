public class Solution {
    public int atoi(String str) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		// We should take care of edge cases!!!
		/* In this question, edge cases include:
		 * (1). number reaches int max
		 * (2). number reaches int minmum
		 */
		 
		 int preedge = Integer.MAX_VALUE/10;
		 int max = Integer.MAX_VALUE;
		 int min = Integer.MIN_VALUE;
		 
		 int res = 0;
		 boolean hasGotSign = false;
		 boolean hasGotDigit = false;
		 int sign = 1;
		 int c = 0;
		 
		 for(int i = 0; i < str.length(); i++)
		 {
			char curr = str.charAt(i);
			if(curr >= '0' && curr <= '9')
			{
				c++;
				hasGotDigit = true;
				//case for numeric digit
				if(c == 11)
				{
					return (sign == 1? max:min);
				}
				
				if(res >= preedge)
				{
					if(curr > '7')
					{
						if(sign > 0)
							return max;
						return min;
					}
					
					return (res*10+(curr-'0'))*sign;
				}
				
				res = res*10 + (curr-'0');
			}
			else
			{
				if(hasGotSign)
					return sign*res;
				if(curr == ' ')
				{
					if(hasGotDigit)
						break;
					else
						continue;
				}
				if(curr == '-')
				{
					sign = -1;
					hasGotSign = true;
				}
				else if(curr == '+')
					hasGotSign = true;
				else
					break;
			}
		 }
		 return sign * res;
    }
}