public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function

	if(num1==null || num2 == null)
		return "0";

	int l1=num1.length();
	int l2=num2.length();

	String rs = "";

	int pre = 0;	
	int c = 0;
	int cc = 0;		
	
	int start = 0;
	int curr = 0;

	while(true)
	{
		if(c == l1+l2-1)
		{
			if(pre == 0)
				break;
			rs = pre+rs;
			break;
		}
		
		if(cc == l1)
		{
			//time to change start bit
			start = start+1;
		}	

		for(int i = curr; i>Math.)

		if(curr < l1)
	}		
	
    }
}
