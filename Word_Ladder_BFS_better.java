public class Solution {
    //Leetcode does not run, test latter
	//This one should work, tested locally and performed really great
	
	public int ladderLength(String start, String end, HashSet<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashMap<String, Integer> record = new HashMap<String, Integer> ();
		int rs = proc(start, end, dict);
		return (rs==Integer.MAX_VALUE?0:rs);
    }
	
	public int proc(String start, String end, HashSet<String> dict)
	{
		int count = 1;
		
		if(start.equals(end))
			return count;
		
		if(ifConvertable(start, end))
			return ++count;
		
		ArrayList<StringPack> sa = new ArrayList<StringPack>();
		StringPack startpack = new StringPack();
		startpack.s = start;
		startpack.level = 1;
		
		sa.add(startpack);
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < sa.size(); i++)
		{
			StringPack currstart = sa.get(i);
			if(currstart.s.equals(end))
				return currstart.level;
			if(ifConvertable(currstart.s, end))
				return currstart.level+1;
			
			ArrayList<StringPack> tmpsa = new ArrayList<StringPack> ();
			for(String curr : dict)
			{
				if(ifConvertable(currstart.s, curr))
				{
					StringPack currpack = new StringPack();
					currpack.s = curr;
					currpack.level = currstart.level+1;
					tmpsa.add(currpack);
				}
			}
			
			for(StringPack curr : tmpsa)
			{
				dict.remove(curr.s);
			}
			
			sa.addAll(tmpsa);
		}
		
		return 0;
	}
	
	public static class StringPack
	{
		String s;
		int level = Integer.MAX_VALUE;
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