public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
		// The idea is to separate string p with star

		return check(s, p);
	}
	
	public boolean check(String s, String p)
	{
		ArrayList<String> pp = prework(p);
		if(pp.size() == 0)
		{
			if((p.length() == 0 && s.length() == 0) || p.length() > 0)
				return true;
			return false;
		}
		
		boolean firstStar = false;
		boolean lastStar = false;
		if(p.charAt(0) == '*')
			firstStar = true;
		if(p.charAt(p.length()-1) == '*')
			lastStar = true;
		
		int len = 0;

		for(String curr : pp)
			len += curr.length();
		
		if(len > s.length())
			return false;

		int c = 0;

		for(int i = 0; i < pp.size(); i++)
		{
			String tmp = pp.get(i);
			int currlen = s.length() - c;
			if(currlen < tmp.length())
				return false;
			if(i == 0)
			{
				if(!firstStar)
				{
					if(!checkEqual(s.substring(0, p.length()-1), tmp))
						return false;
					c = tmp.length()-1;
					continue;
				}
			}

			if(i == pp.size()-1)
			{
				// This is the last part in p
				// Should try to match the very last one
				if(lastStar)
				{
					int tmpc = find(s, tmp, c);
					if(tmpc > 0)
						return true;
					else
						return false;
				}

				String tmps = s.substring(s.length() - tmp.length());
				if(checkEqual(tmps, tmp))
					return true;
				return false;
			}

			int tmpc = find(s.substring(c, s.length()), tmp, c);
			if(tmpc < 0)
				return false;
			c = tmpc;
		}
		return false;
	}
	
	public int find(String s, String p, int c)
	{
		// This function is used to find the position of String p in String s(starting from position c)
		// If there is no such stirng p in string s then return -1
		if(s.length()-c < p.length())
			return -1;

		for(int i = c; i < s.length(); i++)
		{
			if(s.charAt(i) == p.charAt(0))
			{
				if(s.length()-i < p.length())
					continue;
				if(checkEqual(s.substring(i, i+p.length()-1), p))
					return (i+p.length());
			}
		}

		return -1;
	}

	public boolean checkEqual(String s, String p)
	{
		if(s.length() != p.length())
			return false;
		for(int i =0; i < s.length(); i++)
		{
			//System.out.println(s.charAt(i));
			//System.out.println(p.charAt(i));
			if(((s.charAt(i) == p.charAt(i)) || (p.charAt(i) == '?')))
				continue;
			//System.out.println("return false");
			return false;
		}
		//System.out.println("return true");
		return true;
	}
	
	public ArrayList<String> prework(String p)
	{
		StringBuilder sb = new StringBuilder();
		ArrayList<String> rs = new ArrayList<String> ();
		boolean isLastStar = false;
		for(int i = 0; i < p.length(); i++)
		{
			if(p.charAt(i) == '*')
			{
				if(sb.length() != 0)
				{
					String tmp = sb.toString();
					rs.add(tmp);
					sb = new StringBuilder();
				}
			}
			else
			{
				sb.append(p.charAt(i));
			}
		}
		if(sb.length() != 0)
		{
			String tmp = sb.toString();
			rs.add(tmp);
		}
		
		
		return rs;
	}
}