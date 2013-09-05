public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		return recRun(3, num);
    }
	
	public static String recRun(int c, int modnum)
	{
		if(c<0)
			return "";
		int t = (int)Math.pow(10, c);
		int currmod = modnum%t;
		int currnum = (modnum - currmod)/t;
		
		return numProcess(currnum, (c*2+1)) + recRun(c-1, currmod);
	}
	
	public static String numProcess(int num, int s)
	{
		if(num <= 0)
			return "";
		
		String[] unitList = {"", "I", "V", "X", "L", "C", "D", "M", ""};
		
		int base = s;
		int fivebase = s+1;
		int prebase = s-1;
		int nextbase = s+2;
		
		String rs = "";
		if(num == 5)
			return 
	}	
	
}