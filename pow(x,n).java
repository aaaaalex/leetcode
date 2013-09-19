public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(n == 0)
			return 1;
		
		boolean isNega = false;
		
		if(n < 0)
			isNega = true;
		
		double t = x;
		
		for(int i = 1; i < Math.abs(n); i++)
		{
			x *= t;
		}
		
		if(isNega)
			x = 1/x;
		
		return x;
    }
}