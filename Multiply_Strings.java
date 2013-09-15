public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
		//The idea is to use two loops and multiply every digit (use model to get 10s)
        int l1 = num1.length();
		int l2 = num2.length();
		
		if(num1.equals("0") || num2.equals("0"))
			return "0";
		
		String rs = "";
		
		int c = 0;
		int cc = 0;
		int curr = l1-1;
		int start = l2-1;
		int prev = 0;
		while(true)
		{
			if(start < 0)
			{
				if(prev >0)
					rs = prev+rs;
				break;
			}	
			int tmpv = 0;
			for(int i = 0; i <= Math.min(l1-1-curr, start); i++)
			{
				tmpv = tmpv+(num1.charAt(curr+i) - '0')* (num2.charAt(start-i) - '0');
			}
			tmpv = tmpv+prev;
			int tmprs = tmpv%10;
			prev = (tmpv-tmprs)/10;
			rs = tmprs+rs;
				
			cc++;
			if(curr > 0)
				curr--;
			if(cc > l1-1)
			{
				start = start-1;
			}
		}
		return rs;
    }
}