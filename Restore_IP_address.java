public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		return solve(s, 3);
    }
	
	public static ArrayList<String> solve(String s, int c)
	{
		if(s.length() == 0)
		{
			return new ArrayList<String> ();
		}
		
		ArrayList<String> rs = new ArrayList<String> ();
		
		if(c > 0)
		{
			int val = 0;
			int t = 10;
			int tt = 1;
			String currs = "";
			for(int i = 0; i < Math.min(3, s.length() - c); i++)
			{
				int currval = s.charAt(i) - '0';
				currs = currs+currval;
				//val = Integer.parseInt(currs);
				//OR
				val = val * t + currval;
				if(val >= 0 && val <= 255 && (val == 0 || val >= tt) && (!currs.equals("00")) && (!currs.equals("000")))
				{
					ArrayList<String> tmprss = solve(s.substring(i+1), c-1);
					for(String tmprs : tmprss)
					{
						tmprs = currs+"."+tmprs;
						rs.add(tmprs);
					}
				}
				tt *= 10;
			}
			return rs;
		}
		
		if(c == 0)
		{
			if(s.length() > 3 || s.length() == 0)
			{
				return rs;
			}
			
			int val = Integer.parseInt(s);
			if(val >= 0 && val <= 255)
			{
				if(s.charAt(0) == '0' && s.length() > 1)
					return rs;
				rs.add(s);
			}
			return rs;
		}
		
		return rs;
	}	
}