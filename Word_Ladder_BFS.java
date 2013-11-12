public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashMap<String, Integer> record = new HashMap<String, Integer> ();
		int rs = proc(start, end, dict, record);
		return (rs==Integer.MAX_VALUE?0:rs);
    }
	
	public int proc(String start, String end, HashSet<String> dict, HashMap<String, Integer> record)
	{
		if(record.containsKey(start))
			return record.get(start);
		
		if(start.equals(end))
		{
			record.put(start, 1);
			return 1;
		}
		
		if(ifConvertable(start, end))
		{
			record.put(start, 2);
			return 2;
		}
		
		int min = Integer.MAX_VALUE;
		boolean samecount = false;
		ArrayList<String> sa = new ArrayList<String> ();
		
		for(String curr:dict)
		{
			if(ifConvertable(start, curr))
			{
				if(curr.equals(end))
				{
					record.put(curr, 1);
					record.put(start, 2);
					return 2;
				}
				if(ifConvertable(curr, end))
				{
					record.put(curr, 2);
					record.put(start, 3);
					return 3;
				}
				
				sa.add(curr);
			}
		}
		
		
		for(String curr:sa)
		{
			if(curr.equals(start))
			{
				dict.remove(start);
				continue;
			}
			if(ifConvertable(start, curr))
			{
				dict.remove(curr);
				int v = proc(curr, end, dict, record);
				dict.add(curr);
				if(v < min)
					min = v;
			}
		}
		if(min != Integer.MAX_VALUE)
			min++;
		if(samecount)
			dict.add(start);
		return min;
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