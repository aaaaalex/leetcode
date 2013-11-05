public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
		// This way cannot pass time limit
		p = prework(p);
		return check(s, p);
    }
	
	public String prework(String p)
	{
		StringBuilder sb = new StringBuilder();
		boolean isLastStar = false;
		for(int i = 0; i < p.length(); i++)
		{
			if(p.charAt(i) == '*')
			{
				if(!isLastStar)
				{
					sb.append(p.charAt(i));
					isLastStar = true;
				}
			}
			else
			{
				sb.append(p.charAt(i));
				isLastStar = false;
			}
		}
		
		String rs = sb.toString();
		return rs;
	}
	
	public boolean check(String s, String p)
	{
		if(s.length() == 0)
		{
			if(p.length() == 0)
				return true;
			if(p.length() == 1 && p.charAt(0) == '*')
				return true;
			for(int i = 0; i < p.length(); i++)
			{
				if(p.charAt(i) != '*')
					return false;
			}
			return true;
		}
		
		if(p.length() == 0)
			return false;
		
		int i = 0;
		int ii = 0;
		while(i < s.length() && i < p.length() && (p.charAt(i) == s.charAt(i) || p.charAt(i) == '*' || p.charAt(i) == '?'))
		{
			if(p.charAt(i) == '*')
			{
				ii = i;
				while(ii < s.length())
				{		
					if(check(getSubstring(s, ii), getSubstring(p, i+1)))
						return true;
					ii++;
				}
			}
			i++;
		}
		
		return check(getSubstring(s, s.length()), getSubstring(p, i+1));
	}
	
	public String getSubstring(String a, int start)
	{
		String rs = "";
		if(start >=  a.length())
			return rs;
		return a.substring(start);
	}
}