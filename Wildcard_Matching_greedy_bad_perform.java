public class Solution {
	//This one still cannot pass large data set
	public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
		// The idea is to separate string p with star
		if(s == null || p == null)
			return true;
		
		p = prework(p);
		
		int[][] records = new int[s.length()][p.length()];
		return check(s, p, records);
	}
	
	public boolean check(String s, String p, int[][] records)
	{
		
		if(s.length() == 0)
		{
			if(p.length() == 0)
				return true;
			else
			{
				for(int i = 0; i < p.length(); i++)
				{
					if(p.charAt(i) != '*')
						return false;
				}
				return true;
			}
		}
		
		if(p.length() == 0)
			return true;
	
		String subP = "";
		int nextP = p.indexOf("*");
		if(nextP < 0)
		{	
			subP = p;
			nextP = p.length();
		}
		else if(nextP == 0)
		{
			//This case can only happen if there is a star at the beginning of the original P string since original P string is pre-modified for our program
			if(p.length() == 0)
				return true;
			
			int j = 0;
			while(j < s.length())
			{
				if(check(s.substring(j), p.substring(nextP+1), records))
					return true;
				j++;
			}
			
			return false;
		}
		else
		{
			subP = p.substring(0, nextP);
		}
		
		if(nextP > s.length())
			return false;
		
		String subS = s.substring(0, nextP);
		
		if(checkEqual(subS, subP))
		{
			if(nextP == (p.length() - 1) || nextP == p.length())
				return true;
			
			int i = nextP;
			while(i < s.length())
			{
				if(check(s.substring(i), p.substring(nextP+1), records))
					return true;
					i++;
			}
			
		}
		
		return false;
	}
	
	public boolean checkEqual(String s, String p)
	{
		if(s.length() != p.length())
			return false;
		for(int i =0; i < s.length(); i++)
		{
			
			if(((s.charAt(i) == p.charAt(i)) || (p.charAt(i) == '?')))
				continue;

			return false;
		}
		
		return true;
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
}
