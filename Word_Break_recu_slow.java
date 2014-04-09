public class Solution {
	// This version will not pass time limit
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		
		return check(s, dict, 0);
    }
	
	public boolean check(String s, Set<String> dict, int c)
	{
		if(c >= s.length())
			return true;
		
		for(int i = c; i < s.length(); i++)
		{
			String tmp = s.substring(c, i+1);
			if(dict.contains(tmp))
			{
				if(i == s.length()-1)
					return true;
				if(check(s, dict, i+1))
					return true;
			}
		}
		
		return false;
	}
}