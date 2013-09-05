public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return check(s1, s2, s3);
    }
	
	public static boolean check(String s1, String s2, String s3)
	{
		if(s3.length() != s1.length()+s2.length())
			return false;
		
		if(s1.length() == 0 && s2.length() == 0)
			return true;
		
		if(s1.length() == 0)
		{
			if(s2.charAt(0) == s3.charAt(0))
			{
				return check(s1, modSubstring(s2, 1), modSubstring(s3, 1));
			}
			return false;
		}
		
		if(s2.length() == 0)
		{
			if(s1.charAt(0) == s3.charAt(0))
				return check(modSubstring(s1, 1), s2, modSubstring(s3, 1));
			return false;
		}
		
		char cs1 = s1.charAt(0);
		char cs2 = s2.charAt(0);
		char cs3 = s3.charAt(0);
		
		if(cs1 == cs2) 
		{
			if(cs1 == cs3)
			{
				return (check(modSubstring(s1, 1), s2, modSubstring(s3, 1)) || check(s1, modSubstring(s2, 1), modSubstring(s3, 1)));
			}
			return false;
		}
		
		if(cs1 == cs3)
			return check(modSubstring(s1, 1), s2, modSubstring(s3, 1));
			
		if(cs2 == cs3)
			return check(s1, modSubstring(s2,1), modSubstring(s3, 1));
		
		return false;
	}
	
	public static String modSubstring(String s, int start)
	{
		if(start < s.length())
			return s.substring(start);
		return "";
	}
}