public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(n == 0)
			return 1;
			
		if(x == -1)
		{
			if(n%2 == 0)
				return 1;
			else
				return -1;
		}
		
		if(x == 1 || x == 0)
			return x;
			
		boolean isNega = false;
		if(n < 0)
			isNega = true;
		
		int c = 1;
		double t = x;
		double rs = x;
		for(int i = 1; i < Math.abs(n); )
		{
			if(Math.abs(n) - i >= c)
			{
				rs = rs*t;
				t = rs;
				c += c;
				i = c;
				continue;
			}
		
			while(true)
			{
				if(Math.abs(n) - i == c)
					break;
				/* if(c == 1 || Math.abs(x) == Math.abs(t))
				{
					break;
				} */
				t = t/x;
				c--;
			}
			rs = rs*t;
			break;
		}
		
		if(isNega)
			rs = 1/rs;
		
		return rs;
    }
}