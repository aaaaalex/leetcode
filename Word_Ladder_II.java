public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		return proc(start, end, dict);
    }
	
	public ArrayList<ArrayList<String>> proc(String start, String end, HashSet<String> dict)
	{
		int count = 1;
		ArrayList<ArrayList<String>> rs = new ArrayList<ArrayList<String>> ();
		
		if(start.equals(end))
		{
			ArrayList<String> tmprs = new ArrayList<String> ();
			tmprs.add(start);
			rs.add(tmprs);
			return rs;
		}
		if(ifConvertable(start, end))
		{
			ArrayList<String> tmprs = new ArrayList<String> ();
			tmprs.add(start);
			tmprs.add(end);
			rs.add(tmprs);
			return rs;
		}
		ArrayList<StringPack> sa = new ArrayList<StringPack>();
		StringPack startpack = new StringPack();
		startpack.s = start;
		startpack.level = 1;
		
		sa.add(startpack);
		
		int min = Integer.MAX_VALUE;
		ArrayList<StringPack> rspack = new ArrayList<StringPack> ();
		for(int i = 0; i < sa.size(); i++)
		{
			StringPack currstart = sa.get(i);
			
			if(currstart.level >= min)
				break;
			if(currstart.s.equals(end))
			{
				min = Math.min(currstart.level, min);
				rspack.add(currstart);
			}
			if(ifConvertable(currstart.s, end))
			{
				if(currstart.level+1 <= min)
				{
					min = currstart.level+1;
					rspack.add(currstart);
				}
				else
					break;
			}
			ArrayList<StringPack> tmpsa = new ArrayList<StringPack> ();
			for(String curr : dict)
			{
				if(ifConvertable(currstart.s, curr))
				{
					StringPack currpack = new StringPack();
					currpack.s = curr;
					currpack.level = currstart.level+1;
					currpack.pre = currstart;
					tmpsa.add(currpack);
				}
			}
			
			for(StringPack curr : tmpsa)
			{
				dict.remove(curr.s);
			}
			
			sa.addAll(tmpsa);
		}
		
		for(StringPack curr : rspack)
		{
			ArrayList<String> tmprs = new ArrayList<String> ();
			StringPack tmppack =  curr;
			while(tmppack.s != start)
			{
				tmprs.add(0, tmppack.s);
				tmppack = tmppack.pre;
			}
			tmprs.add(0, start);
			tmprs.add(end);
			rs.add(tmprs);
		}
		
		return rs;
	}
	
	public static class StringPack
	{
		String s;
		int level = Integer.MAX_VALUE;
		StringPack pre;
	}
	
	public boolean ifConvertable(String a, String b)
	{
		if(a.length() != b.length())
			return false;
		int c = 0;
		for(int i = 0; i < a.length(); i++)
		{
			if(a.charAt(i) == b.charAt(i))
				continue;
			if(c == 1)
				return false;
			c++;
		}
		return true;
	}
}