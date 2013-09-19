public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(s == null || p == null)
			return false;
		
		if(s.equals(p))
			return true;

		return solve(s, p);
			
    }
	public static String getSub(String s, int ss, int ee)
	{
		if(ss >= ee || ss >= s.length())
		{
			return "";
		}
		return s.substring(ss, ee);
	}
	public static boolean solve(String s, String p)
	{
		if(s.length() == 0)
		{
			if(p.length() == 0)
				return true;
			if(p.length() == 1)
				return false;
			char currp = p.charAt(1);
			if(currp == '*')
				return solve(s, getSub(p, 2, p.length()));
			
		}
		if(p.length() == 1)
		{
			if(s.length() == 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)))
				return true;
			return false;
		}
		
		if(p.length()==0)
		{
			if(s.length() == 0)	
				return true;
			return false;
		}
		
		if(p.charAt(1) != '*')
		{		
			return (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && solve(getSub(s, 1, s.length()), getSub(p, 1, p.length())));
		}
		else
		{
			int l = 0;
			
			while(l < s.length()&&(p.charAt(0) == '.' || p.charAt(0) == s.charAt(l)))
			{
				if(solve(getSub(s, l, s.length()), getSub(p, 2, p.length())))
					return true;
				l++;
			}
			
			return solve(getSub(s, l, s.length()), getSub(p,2, p.length()));
		}
	}
}