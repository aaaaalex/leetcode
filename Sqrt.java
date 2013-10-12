public class Solution {
    public int sqrt(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		if(x == 0 || x == 1)
			return x;
		
		//To handle exception case
		if(x < 0)
			return -1;
		
		double eoc = 0.000001;
		
		double rs = calculate(x, x, eoc);
		/*The commented part is only for find best solution (closest). But for leetcode, it is not necessary.
		if((rs - (int)rs) > 0.5)
			return (int)rs+1;
		*/
		
		return (int) rs;
    }
	
	//The idea is to use Newton's method.
	//Xn+1 = Xn - ((f(Xn))/(f'(Xn)))
	public static double calculate(double x, int target, double eoc)
	{
		if(Math.abs(x*x - target) < eoc)
			return x;
		else
			return calculate(((x+ (target/x))/2), target, eoc);
	}
}