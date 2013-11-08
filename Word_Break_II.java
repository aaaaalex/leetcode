public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashMap<Integer, ArrayList<String>> record = new HashMap<Integer, ArrayList<String>> ();
		boolean[][] isVist = new boolean[s.length()][s.length()];
		boolean[] c = new boolean[26];
		
		for(String ts : dict)
		{
			for(int i = 0; i < ts.length(); i++)
			{
				c[ts.charAt(i) - 'a'] = true;
			}
		}
		
		for(int i = 0; i < s.length(); i++)
		{	
			if(!c[s.charAt(i) - 'a'])
				return new ArrayList<String> ();
		}
		return match(s, 0, s.length()-1, dict, record, isVist);
    }
	
	public ArrayList<String> match(String s, int i, int j, Set<String> dict, HashMap<Integer, ArrayList<String>> record, boolean[][] isVist)
	{
		int key = (s.length()*i)+j;
		if(isVist[i][j])
		{
			return record.get(key);
		}
		isVist[i][j] = true;
		ArrayList<String> tmprs = new ArrayList<String> ();
		HashSet<String> tmprecord = new HashSet<String> ();
		String s0 = s.substring(i, j+1);
		if(dict.contains(s0))
		{
			tmprs.add(s0);
			tmprecord.add(s0);
		}
	
		for(int k = i+1; k<=j; k++)
		{
			ArrayList<String> a1 = match(s, i, k-1, dict, record, isVist);
			ArrayList<String> a2 = match(s, k, j, dict, record, isVist);
			if(a1.size() == 0 || a2.size() == 0)
				continue;
			for(String s1 : a1)
			{
				for(String s2 : a2)
				{
					String tmp = s1+" "+s2;
					if(tmprecord.add(tmp))
						tmprs.add(tmp);
				}
			}
		}
		
		record.put(key, tmprs);
		return tmprs;
	}
}