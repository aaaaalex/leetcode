public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(s1.length() != s2.length())
			return false;
		
		return solve(s1, s2);
    }
	
	public static boolean solve(String s1, String s2)
	{
		if(s1.length() != s2.length())
			return false;
		if(s1.length() == 0)
			return true;
		if(s1.length() == 1)
		{
			if(s1.charAt(0) == s2.charAt(0))
				return true;
			return false;
		}
		
		for(int i = 1; i < s1.length(); i++)
		{
			if((solve(s1.substring(0, i), s2.substring(0, i))&&solve(s1.substring(i, s1.length()), s2.substring(i, s2.length()))) || (solve(s1.substring(0, i), s2.substring(i, s2.length()))&&solve(s1.substring(i, s1.length()), s2.substring(0, i))))
				return true;
		}
		return false;
	}
}