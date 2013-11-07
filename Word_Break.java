public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		boolean[s.length()] isMat = new boolean[s.length()];
		boolean[s.length()] isVis = new boolean[s.length()];
		
		
    }
	
	public boolean check(String s, Set<String> dict, boolean[] isMat, boolean[] isVis, int c)
	{
		if(c >= s.length())
			return true;
		isVis[c] = true;
		for(int i = c; i < s.length(); i++)
		{
			String tmp = s.substring(c, i);
			if(dict.contains(tmp))
			{
				if(i == s.length()-1)
					return true;
				if(isVis[i+1])
				{
					if(isMat[i+1])
					{
						isMat[c] = true;
						return true;
					}
				}
			}
		}
	}
}