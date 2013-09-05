public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = s.length();
		if(s.length() == 0)
			return 0;
		int f = s.charAt(0) - '0';
		if(f == 0)
			return 0;
		
		int prev = 1;
		int pprev = 1;
		
		for(int i = 1; i<l; i++)
		{
			int preval = s.charAt(i-1) - '0';
			int curr = s.charAt(i) - '0';
			//If one zeros comes
			if(curr == 0)
			{
				if(10*preval+curr > 26)
					return 0;
				
				prev = pprev;
				//Two consective zeros means no way!
				if(i < l-1)
				{
					int nextval = s.charAt(i+1) - '0';
					if(nextval == 0)
						return 0;
				}
			}
			else
			{
				if(i == 1)
				{
					if(preval*10+curr <= 26 && preval != 0)
					{
						pprev = prev;
						prev = prev + 1;
					}
				}
				else
				{
					if(preval*10+curr <= 26 && preval != 0)
					{
						int tmp = pprev;
						pprev = prev;
						prev = prev + tmp;
					}
					else
					{
						pprev = prev;
					}
				}
			}
			
			
		}
		return prev;
    }
	
}