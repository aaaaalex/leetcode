public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
		// The idea is to separate string p with star
		
		
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
		
		
		
		for(int i = 0; i < pp.size(); i++)
		{
			String tmp = pp.size();
			
		}
		
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