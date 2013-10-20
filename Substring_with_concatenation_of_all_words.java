public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        //(1) each word in L exactly show once
		//(2) without any intervening characters
		
		if(L == null || S == null || L.length == 0 || S.length() == 0)
			return new ArrayList<Integer> ();
		
		int len = L[0].length();
		
		if(len * L.length > S.length())
			return new ArrayList<Integer> (); 
		
		HashMap<String, Integer> records = new HashMap<String, Integer> ();
		ArrayList<Integer> rs = new ArrayList<Integer> ();
		for(String l : L)
		{
			if(records.containsKey(l))
				records.put(l, records.get(l)+1);
			else
				records.put(l, 1);
		}
		
		boolean[] checks = new boolean[S.length()];
		
		
		for(int i = 0; i < S.length(); i++)
		{
			if(find(S, len, i, records))
				rs.add(i);
		}
		
		return rs;
    }
	
	public static boolean find(String S, int len, int p, HashMap<String, Integer> records)
	{
		if(records.size() == 0)
			return true;
		
		if(p+len-1 >= S.length())
			return false;
		
		if(records.containsKey(S.substring(p, p+len)))
		{
			int c = records.get(S.substring(p, p+len));
			if(c == 1)
				records.remove(S.substring(p, p+len));
			else
				records.put(S.substring(p, p+len), c-1);
			boolean rs = find(S, len, p+len, records);
			records.put(S.substring(p, p+len), c);
			return rs;
		}
		
		return false;
	}
}